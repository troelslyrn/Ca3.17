import React from 'react';
import { StyleSheet, Text, View, Button } from 'react-native';
import ImagePickerExample from './components/ImagePickerExample';
import LocationEx from './components/LocationEx';
import Test from './components/Test';

export default class App extends React.Component {
    render(){
        // return (<ImagePickerExample/>);
        return (<LocationEx/>);
        // return (<Test/>);
    }
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
