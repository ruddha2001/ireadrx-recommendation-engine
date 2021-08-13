import { useEffect, useState } from "react";

export interface AllChemicalsProps {
    
}
 
const AllChemicals: React.FC<AllChemicalsProps> = () => {
    const [chemicals, setChemicals] = useState([]);
    useEffect(() => {}, [])
    return ( <div>

    </div> );
}
 
export default AllChemicals;