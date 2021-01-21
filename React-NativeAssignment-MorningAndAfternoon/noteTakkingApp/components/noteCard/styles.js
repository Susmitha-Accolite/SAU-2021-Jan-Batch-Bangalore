import { StyleSheet } from "react-native";
import { Dimensions } from 'react-native';

const styles = StyleSheet.create({
    detailsContainer: {
        flex: 1,
        flexDirection: 'row',
        flexWrap: 'wrap',
    },
    contentContainer: {
        flex: 1,
        flexWrap: 'wrap',
        borderBottomColor: "black",
        borderStyle:  'dashed',
        borderBottomWidth: 1,
        padding: 5,
        marginLeft: 7,
        marginRight: 7
    },
    noteTitle: {
        width: '60%',
        fontSize: 20,
        color: "black",
        fontWeight: "bold",
        padding: 5,
        marginLeft: 5
    },

    deleteBtn: {
        backgroundColor: "red",
        borderRadius: 50,
        marginLeft: 80,
        marginTop: 10,
        padding: 5,
        width: Dimensions.get('window').width * 0.1,
        textAlign: "center",
        fontWeight: "bold",
        color: "white"
    }

});


export default styles;