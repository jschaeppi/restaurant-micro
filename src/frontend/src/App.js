import { Container } from '@material-ui/core';
import './App.css';
import Nav from './components/Nav';
import { Main } from './pages/Main';

function App() {
  return (
    <Container fixed>
      <Nav />
      <Main />
    </Container>
  );
}

export default App;
