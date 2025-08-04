import { Component } from "react";

export class ListOfPlayers extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return ( 
      <div>
      <h1>List of Players</h1>
        <ul>
           { this.props.players.map((player, index) => {
          return <li>Mr. {player.name} {player.score}</li>;
        })}
        </ul>
      </div>
    );
  }
}
