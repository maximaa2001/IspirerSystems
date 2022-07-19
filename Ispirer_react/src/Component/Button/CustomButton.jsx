import React from "react";

import { Button } from "react-bootstrap";

const CustomButton = ({children, ...props}) =>{


return(<Button variant="success" {...props}>{children}</Button>)

}


export default CustomButton