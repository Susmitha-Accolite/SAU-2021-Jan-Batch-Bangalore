import React from "react";
import { Text, TextInput, View } from "react-native";
import { NewCard } from "../../../components/index";
const AddNotes = ({ navigation }) => {
    return (
        <View>
            <NewCard navigation={navigation} />
        </View>
    );
}

export default AddNotes;