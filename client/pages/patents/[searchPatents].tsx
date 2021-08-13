import { useRouter } from "next/router";
import { useState, useEffect } from "react";
import * as mock from "./mock.json";

export interface SearchPatentsProps {}

const SearchPatents: React.SFC<SearchPatentsProps> = () => {
  const router = useRouter();
  const [name, setName] = useState("");
  const [results, setResults] = useState<string[]>([]);
  const [recommendations, setRecommendations] = useState<string[]>([]);
  const [loading, setLoading] = useState(false);
  useEffect(() => {
    const params = router.asPath.split("/")[2];
    console.log(params);
    setName(params);
    async function mockResults(): Promise<void> {
      setLoading(true);
      const mockData = JSON.parse(JSON.stringify(mock)) as {
        patentId: string;
      }[];
      console.log(typeof mockData);
      setRecommendations(mock.map((e) => e.patentId));
      setLoading(false);
    }
    mockResults();
  }, [router]);
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
          <div className='flex-1'>
              <p className='text-center font-bold text-2xl'>Results</p>
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
          {recommendations.length === 0 ? (
            <p className='text-center'>No Recommendations</p>
          ) : (
            <div className='flex-1'>
                <p className='text-center font-bold text-2xl'>Recommendations</p>
              {recommendations.map((e) => (
                <div
                  key={recommendations.indexOf(e)}
                  className="bg-gray-300 p-8 m-4 rounded-md"
                >
                  {e.toString()}
                </div>
              ))}
            </div>
          )}
        </div>
      )}
    </div>
  );
};

export default SearchPatents;
