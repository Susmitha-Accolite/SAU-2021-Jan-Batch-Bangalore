import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
    container: {
        height: "100%",
        justifyContent: "center",
        alignSelf: "center",
    },
    textInputStyle: {
        borderColor: "#4de429",
        borderWidth: 1,
        borderRadius: 10,
        fontSize: 20,
        padding: 4,
        width: "80%",
        marginBottom: 20,
    },
    loginTextStyle: {
        fontSize: 23,
        fontWeight: "bold",
        marginVertical: 20,
    },
    btn: {
        padding: 5,
        margin: 3,
        backgroundColor: '#4de429',
        borderRadius: 20
    },
    btnText: {
        color: "black",
        fontWeight: "bold",
        textAlign: "center"
    }
});

export default styles;