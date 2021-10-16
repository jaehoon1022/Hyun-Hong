import { Route } from 'react-router-dom';
import Header from './components/common/Header';

import HomePage from './pages/HomePage';
import LoginPage from './pages/LoginPage';
import ResultPage from './pages/ResultPage';
import RegisterPage from './pages/RegisterPage';
import GlobalStyles from './lib/styles/GlobalStyles';

const App = () => {
  return (
    <div>
      <GlobalStyles />
      <Header />
      <Route component={HomePage} path="/" exact />
      <Route component={ResultPage} path="/@:username" exact />
      <Route component={LoginPage} path="/login" exact />
      <Route component={RegisterPage} path="/register" exact />
    </div>
  );
};
export default App;
