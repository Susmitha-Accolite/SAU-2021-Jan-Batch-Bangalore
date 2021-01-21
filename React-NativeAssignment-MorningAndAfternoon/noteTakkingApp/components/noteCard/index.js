import React from "react";
import { TouchableOpacity, View, Text } from "react-native";
import styles from "./styles";
import AsyncStorage from '@react-native-community/async-storage';

const NoteCard = ({ noteData, navigation }) => {

    const deleteCard = async (id) => {


        console.log("delete card", id);
        let currentList = JSON.parse(await AsyncStorage.getItem("notesList"));

        for (var i in currentList) {
            console.log(i, id, currentList[i].id)
            if (currentList[i].id == id) {
                currentList.splice(parseInt(i), 1);

            }
        }
        console.log("after deleting", currentList)
        await AsyncStorage.setItem("notesList", JSON.stringify(currentList));
        currentList = JSON.parse(await AsyncStorage.getItem("notesList"));
        navigation.reset({
            index: 0,
            routes: [{ name: "view-notes" }],
        });
    }

    return (
        <View>
            <View style={styles.detailsContainer}>
                {console.log("inside note card componet", noteData.note.title)}
                <Text style={styles.noteTitle}> {noteData.note.title} </Text>
                <TouchableOpacity onPress={() => deleteCard(noteData.id)} >
                    <Text style={styles.deleteBtn}>X</Text>
                </TouchableOpacity>
            </View>
            <Text style={styles.contentContainer}> {noteData.note.content} </Text>

        </View>
    );
}

export default NoteCard;