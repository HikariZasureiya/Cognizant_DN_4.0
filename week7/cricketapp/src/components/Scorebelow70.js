import { Component } from "react";

export class Scorebelow70 extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div>
        <ul>
          {this.props.players.map((player, index) => {
            if (player.score < 70)
              return (
                <li>
                  Mr. {player.name} {player.score}
                </li>
              );
          })}
        </ul>
      </div>
    );
  }
}
