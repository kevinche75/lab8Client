import java.util.ListResourceBundle;

public class Resources_es_NI extends ListResourceBundle {

    private static final Object[][] contents = {
            {MessageType.DISCONNECTION.name(), "El servidor no está disponible"},
            {MessageType.COMMAND_UNDONE.name(), "El comando no se ha ejecutado"},
            {MessageType.MAX_NUMBER.name(), "Número máximo de usuarios"},
            {MessageType.FALSE_LOGIN.name(), "Nombre de usuario o contraseña incorrectos"},
            {MessageType.FALSE_REGISTER_LOGIN.name(), "Formato de Inicio de sesión incorrecto"},
            {MessageType.ALREADY_EXIST.name(), "El usuario con ese nombre ya existe"},
            {MessageType.TRUE_REGISTER_LOGIN.name(), "Se le enviará un código único al correo"},
            {MessageType.TOKEN_IS_ACTIVE.name(), "Tal usuario ya existe, o el token para este usuario aún está activo"},
            {MessageType.TRUE_REGISTRATION.name(), "¿Está registrado?"},
            {MessageType.FALSE_REGISTRATION.name(), "No se ha especificado correctamente el código único"},
            {MessageType.ERROR.name(), "Error de Recepción de datos"},
            {MessageType.TOKEN_UNREACHED.name(), "El tiempo del token ha expirado"},
            {MessageType.JSON_EXCEPTION.name(), "Error de análisis de archivos"},
            {TextType.UNKNOWN_MESSAGE.name(), "Mensaje desconocido del servidor"},
            {TextType.WRITE_TOKEN.name(), "Introduzca el token"},
            {TextType.MESSAGE_SENDED.name(), "Solicitud enviada"},
            {TextType.WRONG_FORMAT_TOKEN.name(), "Formato de token incorrecto"},
            {TextType.WRONG_FORMAT_PORT.name(), "Formato de puerto incorrecto"},
            {TextType.MAX_PORT_SIZE.name(), "Umbral excedido"},
            {TextType.CHECK_BUTTON.name(), "Conectarse"},
            {TextType.EXIT_BUTTON.name(), "Salida"},
            {TextType.PORT_LABEL.name(), "Аgregar puerto"},
            {TextType.RUSSIAN.name(), "Rusa"},
            {TextType.TURKISH.name(), "Turca"},
            {TextType.UKRAINIAN.name(), "Ucraniana"},
            {TextType.SPANISH_NI.name(), "Español"},
            {TextType.WRITE_LOGIN.name(), "Introduzca el nombre de usuario"},
            {TextType.WRITE_PASSWORD.name(), "Introduzca la contraseña"},
            {TextType.LOGIN_BUTTON.name(), "Entrada"},
            {TextType.REGISTER_BUTTON.name(), "Registro"},
            {TextType.BACK_BUTTON.name(), "Atrás"},
            {TextType.LOGIN_LABEL.name(), "login"},
            {TextType.PASSWORD_LABEL.name(), "Contraseña"},
            {TextType.CHOOSE_OBJECT.name(), "Seleccione un objeto"},
            {TextType.CHOOSE_PATH.name(), "Especifique la ruta"},
            {TextType.TABLE.name(), "Tabla"},
            {TextType.PANEL.name(), "Imagen gráfica"},
            {TextType.WELCOME_LABEL.name(), "Bienvenido, "},
            {TextType.CHANGER_LABEL.name(), "Editor"},
            {TextType.DATE_LABEL.name(), "Fecha creación:"},
            {TextType.SIZE_LABEL.name(), "Tamaño:"},
            {TextType.NAME_LABEL.name(), "Nombre:"},
            {TextType.CUP_OF_TEA.name(), "Taza de té"},
            {TextType.FULLNESS_LABEL.name(), "Ocupación:"},
            {TextType.TEA_TYPE_LABEL.name(), "Tipo de té:"},
            {TextType.ADD_BUTTON.name(), "Agregar"},
            {TextType.CHANGE_BUTTON.name(), "Cambiar"},
            {TextType.REMOVE_BUTTON.name(), "Eliminar"},
            {TextType.REMOVE_ALL_BUTTON.name(), "Eliminar todo"},
            {TextType.REMOVE_GREATER_BUTTON.name(), "Eliminar grandes"},
            {TextType.IMPORT_BUTTON.name(), "Importar desde archivo"},
            {TextType.CLASS_COLLECTION_LABEL.name(), "La colección almacena objetos de tipo: Alice"},
            {TextType.PATH_LABEL.name(), "Ruta:"},
            {TextType.COLLECTION_LABEL.name(), "Colección"},
            {TextType.COUNT_LABEL.name(), "Número de objetos de colección:"},
            {TextType.FILE_NOT_EXIST.name(), "El archivo no existe"},
            {TextType.IS_NOT_FILE.name(), "No es un archivo"},
            {TextType.CANNOT_READ.name(), "No se puede Leer el archivo"},
            {TextType.OWNER_LABEL.name(), "Propietario:"},
            {TextType.POLITENESS_LABEL.name(), "Cortesía:"},
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
