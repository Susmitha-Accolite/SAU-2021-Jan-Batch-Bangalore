import { StyleSheet } from "react-native";
import { Dimensions } from 'react-native';

const styles = StyleSheet.create({
    container: {
        flex: 1,
        height: Dimensions.get("window").height,
    },
    scrollView: {
        marginBottom: Dimensions.get("window").height * 0.01
    },
    floatingButton: {
        flex: 1,
        justifyContent: 'flex-end'
    },
    btn: {
        position: 'absolute',
        width: 50,
        height: 50,
        alignItems: 'center',
        justifyContent: 'center',
        right: 30,
        bottom: 30,
    },
    btnText: {
        color: "blue",
        fontWeight: "bold",
        textAlign: "center"
    },
    FloatingButtonStyle: {
        resizeMode: 'contain',
        width: 50,
        height: 50,
    },
    noNotesContainer: {
        height: "100%",
        justifyContent: "center",
        alignSelf: "center",
    },
    noNotesText: {
        paddingTop: Dimensions.get("window").height*0.3,
        color: "blue",
        fontSize:30,
        fontWeight: "bold",
        textAlign: "center"
    }
});

export default styles;