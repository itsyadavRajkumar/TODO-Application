import logo from './logo.svg';
import './App.css';
import TodoMenu from './component/TodoMenu';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <TodoMenu />
      </header>
    </div>
  );
}

export default App;