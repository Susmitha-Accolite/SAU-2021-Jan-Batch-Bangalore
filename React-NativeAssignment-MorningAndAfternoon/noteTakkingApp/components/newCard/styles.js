import { StyleSheet } from "react-native";
import { Dimensions } from 'react-native';

const styles = StyleSheet.create({
    container: {
        height: Dimensions.get("window").height * 0.3,
        width: Dimensions.get('window').width * 0.9,
        justifyContent: "center",
        alignSelf: "center"
    },
    titleTextStyle: {
        fontSize: 23,
        fontWeight: "bold",
        marginVertical: 20,
    },
    contentTextStyle: {
        borderColor: "green",
        borderWidth: 1,
        fontSize: 18,
        padding: 4,
        width: "95%",
        height:"60%",
        marginBottom: 20,
    },

    btn: {
        padding: 5,
        margin: 3,
        backgroundColor: 'green',
        borderRadius: 50,
        width: Dimensions.get('window').width * 0.2,
    },
    btnText: {
        color: "white",
        fontWeight: "bold",
        textAlign: "center",
    }
});

export default styles;