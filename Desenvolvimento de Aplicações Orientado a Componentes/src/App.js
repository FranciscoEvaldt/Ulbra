import React from "react";
import "./assets/css/App.css";
import BuscaCEP from "./components/cep/Cep";
import Header from "./components/header/Header";
import Usuario from "./components/user/User";
import Formulario from "./components/forms/Forms";

function App() {
  return (
    <div>
      <div>
        <Header title={"Entrevero"} />
        <Usuario name={"Francisco"} />
      </div>
      <BuscaCEP />
      <div>
        <Formulario />
      </div>
    </div>
  );
}

export default App;
