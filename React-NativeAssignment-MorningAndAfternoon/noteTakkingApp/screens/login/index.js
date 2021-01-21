import React, { useState, useEffect } from "react";
import { View, TextInput, Text, Image } from "react-native";
import AsyncStorage from '@react-native-community/async-storage';
import Button from "./button";
import styles from "./styles";

const Login = ({ navigation }) => {

    const [userName, setUserName] = useState("");

    const checkAuth = async () => {
        const currentUser = await AsyncStorage.getItem("userName");
        if (currentUser) {
            navigation.reset({
                index: 0,
                routes: [{ name: "view-notes" }],
            });
        }
        return;
    }

    useEffect(() => {
        checkAuth();
    }, []);

    const login = async () => {
        await AsyncStorage.setItem("userName", userName);

        navigation.reset({
            index: 0,
            routes: [{ name: "view-notes" }],
        });
    }
    return (
        <View style={styles.container}>
            <Image source={require('./icons8-male-user-24.png')}/>
            <Text style={styles.loginTextStyle}> Login </Text>
            <TextInput placeholder="Enter username" style={styles.textInputStyle} onChangeText={(text) => setUserName(text)} />
            <TextInput style={styles.textInputStyle} placeholder="Enter password" />
            <Button title="Login" action={login} />
        </View>
    )
}

export default Login;