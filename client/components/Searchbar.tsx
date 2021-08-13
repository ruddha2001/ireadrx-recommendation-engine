import { Router, useRouter } from "next/dist/client/router";
import { FormEvent, useState } from "react";

export interface SearchBarProps {
  className?: string;
}

const SearchBar: React.FC<SearchBarProps> = (props?: SearchBarProps) => {
  const router = useRouter();
  const [type, setType] = useState("chemicals");
  const [value, setValue] = useState("");

  function handleSubmit(e: FormEvent<HTMLFormElement>) {
    e.preventDefault();
    router.push(`/${type}/${value}`);
  }
  return (
    <form onSubmit={(e) => handleSubmit(e)}>
      <div className={props?.className ?? ""}>
        <div className="relative mx-auto text-gray-600 border-2 border-gray-300 bg-white h-10 px-5 pr-16 rounded-lg">
          <select
            name="type"
            id="type"
            onChange={(e) => setType(e.target.value)}
          >
            <option value="chemicals">Chemicals</option>
            <option value="patents">Patent</option>
          </select>
          <input
            className="rounded-lg text-sm focus:outline-none"
            type="text"
            name="search"
            placeholder="Search"
            onChange={(e) => setValue(e.target.value)}
            required
          />
          <button type="submit" className="absolute right-0 top-0 mr-4 mt-2">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              className="h-6 w-6"
              fill="none"
              viewBox="0 0 24 24"
              stroke="currentColor"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={2}
                d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"
              />
            </svg>
          </button>
        </div>
      </div>
    </form>
  );
};

export default SearchBar;
