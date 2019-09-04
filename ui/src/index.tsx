import * as React from 'react';
import * as ReactDOM from 'react-dom';
import 'semantic-ui-css/semantic.min.css';
import AppRoutes from "./routes";

ReactDOM.render(
    <AppRoutes />,
  document.getElementById('root') as HTMLElement
);
