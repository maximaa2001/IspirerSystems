import React from "react";

const CustomComboBox = ({elements, ...props}) =>{


return(<select class="form-control" {...props}>
    {elements.map((item) => <option key={item} value={item}>{item}</option>)}

</select>)

}


export default CustomComboBox