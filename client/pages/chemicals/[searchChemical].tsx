import { useRouter } from "next/router";
import { useEffect, useState } from "react";
import * as mock from "./mock.json";

export interface ChemicalSearchProps {}

const ChemicalSearch: React.FC<ChemicalSearchProps> = () => {
  const router = useRouter();
  const [name, setName] = useState("");
  const [results, setResults] = useState<string[]>([]);
  const [recommendations, setRecommendations] = useState<string[]>([]);
  const [loading, setLoading] = useState(false);
  useEffect(() => {
    const params = router.asPath.split("/")[2];
    console.log(params);
    setName(params);
    async function fetchResults(): Promise<void> {
      const data = await fetch(
        `${process.env.NEXT_PUBLIC_API_ROUTE}/search/chemicals/?chemicalName=${name}`
      );
      if (data.status === 200) {
        console.log(await data.json());
        setResults(
          (await data.json()).map(
            (e: { chemicalName: string }) => e.chemicalName
          )
        );
      } else {
        console.log(data);
      }
    }
    async function mockResults(): Promise<void> {
      setLoading(true);
      const mockData = JSON.parse(JSON.stringify(mock)) as {
        chemicalName: string;
      }[];
      console.log(typeof mockData);
      setResults(mock.map((e) => e.chemicalName));
      setLoading(false);
    }
    mockResults();
  }, [name, router]);
  return (
    <div>
      <div className="p-8 text-xl flex">
        Showing results for{" "}
        <p className="italic underline font-semibold">{name}</p>
      </div>
      {loading ? (
        <div>Loading</div>
      ) : (
        <div className="flex">
          <div className="flex-1">
            <p className="text-center font-bold text-2xl">Recommendations</p>
            {results.length === 0 ? (
              <p className='text-center'>Nothing to show</p>
            ) : (
              results.map((e) => (
                <div
                  key={results.indexOf(e)}
                  className="bg-gray-300 p-8 m-4 rounded-md"
                >
                  {e}
                </div>
              ))
            )}
          </div>
          <div className="flex-1">
            <p className="text-center font-bold text-2xl">Recommendations</p>
            {recommendations.length === 0 ? (
              <p className='text-center'>No Recommendations</p>
            ) : (
              recommendations.map((e) => (
                <div
                  key={recommendations.indexOf(e)}
                  className="bg-gray-300 p-8 m-4 rounded-md"
                >
                  {e.toString()}
                </div>
              ))
            )}
          </div>
        </div>
      )}
    </div>
  );
};

export default ChemicalSearch;
