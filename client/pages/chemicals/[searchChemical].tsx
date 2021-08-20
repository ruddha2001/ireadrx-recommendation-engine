import { useRouter } from "next/router";
import { useEffect, useState } from "react";
import * as mock from "./mock.json";

export interface ChemicalSearchProps {}

const ChemicalSearch: React.FC<ChemicalSearchProps> = () => {
  const router = useRouter();
  const [name, setName] = useState("");
  const [results, setResults] = useState<string[]>([]);
  const [recommendations, setRecommendations] = useState<string[]>([]);
  const [loading, setLoading] = useState(true);
  useEffect(() => {
    const params = router.query.searchChemical as string;
    console.log(params);
    setName(params);
    async function fetchResults(name: string): Promise<void> {
      console.log('Param : ', name);
      const data = await fetch(
        `${process.env.NEXT_PUBLIC_API_ROUTE}/recommend/chemical/?chemicalName=${name}`
      );
      if (data.status === 200) {
        const responseData= await data.json() || [] as string[];
        console.log(responseData);
        setResults(
          responseData.map(
            (e) => e
          )
        );
      } else {
        console.log(data);
      }
      setLoading(false);
    }
    if(params){
      fetchResults(params);
    }
  }, [name, router]);
  return (
    <div>
      <div className="p-8 text-xl flex">
        Showing results for{" "}
        <p className="italic underline font-semibold">{name}</p>
      </div>
      {loading ? (
        <div className='text-center text-xl font-bold'>Loading</div>
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
        </div>
      )}
    </div>
  );
};

export default ChemicalSearch;
