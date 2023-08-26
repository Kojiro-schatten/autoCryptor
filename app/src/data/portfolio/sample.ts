import { Component } from 'react';

export class DisplayConstructor extends Component {
  name: string;
  hoge: string;

  constructor(name: string, hoge: string) {
    super(name, hoge)
    this.name = name;
    this.hoge = hoge;
  }
}
