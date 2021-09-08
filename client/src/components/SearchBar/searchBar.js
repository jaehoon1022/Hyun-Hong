import './searchBar.css';
import { useState } from 'react';
const SearchBar = () =>{
  const [nickName, setNickName] = useState('')
  const onChange = e => {
    setNickName(e.target.value)
  }
  const onClick = () =>{
    console.log(nickName)
  }
  return(
    <div>
      <input value = {nickName} onChange={onChange} type="search" placeholder="닉네임을 검색해주세요"></input>
      <button onClick={onClick}>검색</button>
    </div>
  )
}


export default SearchBar;
