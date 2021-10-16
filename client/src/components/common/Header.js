import styled from 'styled-components';
import palette from '../../lib/styles/palette';

const HeadBlock = styled.div`
  display: flex;
  position: fixed;
  align-items: center;
  width: 100%;
  height: 4rem;
  background: ${palette.blue};
  justify-content: space-between;
  .logo {
    display: flex;
    align-items: center;
    margin-left: 3rem;
  }
  .right {
    display: flex;
    align-items: center;
    margin-right: 3rem;
  }
`;
const Spacer = styled.div`
  height: 4rem;
`;
const Header = () => {
  return (
    <>
      <HeadBlock>
        <div className="logo">로고자리</div>
        <div>OP.GG</div>
        <button className="right">로그인</button>
      </HeadBlock>
      <Spacer />
    </>
  );
};

export default Header;
