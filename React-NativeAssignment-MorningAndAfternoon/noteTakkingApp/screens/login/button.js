import React from "react";
import { TouchableOpacity, Text, StyleSheet } from "react-native";
import styles from "./styles";
const Button = ({ title, action }) => {
    return (
        <TouchableOpacity style={styles.btn} onPress={action}>
            <Text style={styles.btnText}> {title}</Text>
        </TouchableOpacity>
    );
}

export default Button;