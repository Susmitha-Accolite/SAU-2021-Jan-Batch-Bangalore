import React, { useState } from "react";
import { TextInput, View } from "react-native";
import AsyncStorage from '@react-native-community/async-storage';
import Button from "./button";
import styles from "./styles";
const NewCard = ({ navigation }) => {
    const [noteTitle, setNoteTitle] = useState("");
    const [noteContent, setNoteContent] = useState("");

    const submitNote = async () => {
        var newNote = {
            "title": noteTitle,
            "content": noteContent
        }
        console.log(newNote);
        var notesList = await AsyncStorage.getItem("notesList");
        console.log("notesList", JSON.parse(notesList))
        notesList = JSON.parse(notesList);
        if (notesList === null) {
            notesList = [
                {
                    id: "1",
                    note: newNote,
                }
            ]
        } else {
            let noteId = notesList.length + 1;
            notesList.push(
                {
                    id: noteId,
                    note: newNote,
                }
            )
        }
        await AsyncStorage.setItem('notesList', JSON.stringify(notesList));
        navigation.goBack();
    }
    return (
        <View style={styles.container}>
            <TextInput style={styles.titleTextStyle} placeholder="Title" onChangeText={setNoteTitle} />
            <TextInput multiline style={styles.contentTextStyle} placeholder="Enter notes.... " onChangeText={setNoteContent} />
            <Button title="Save" action={submitNote} />


        </View>
    );
}

export default NewCard;