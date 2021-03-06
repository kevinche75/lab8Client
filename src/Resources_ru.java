import java.util.ListResourceBundle;

public class Resources_ru extends ListResourceBundle {

    private static final Object[][] contents = {
            {MessageType.DISCONNECTION.name(), "Сервер недоступен"},
            {MessageType.COMMAND_UNDONE.name(), "Комманда не выполнена"},
            {MessageType.MAX_NUMBER.name(), "Максимальное число пользователей"},
            {MessageType.FALSE_LOGIN.name(), "Неправильный логин или пароль"},
            {MessageType.FALSE_REGISTER_LOGIN.name(), "Неправильный формат логина"},
            {MessageType.ALREADY_EXIST.name(), "Пользователь с таким именем уже существует"},
            {MessageType.TRUE_REGISTER_LOGIN.name(), "Вам на почту отправлен уникальный код"},
            {MessageType.TOKEN_IS_ACTIVE.name(), "Такой пользователь уже существует, либо токен для этого пользователя ещё активен"},
            {MessageType.TRUE_REGISTRATION.name(), "Вы зарегистрированы"},
            {MessageType.FALSE_REGISTRATION.name(), "Неправильно указан уникальный код"},
            {MessageType.ERROR.name(), "Ошибка получения данных"},
            {MessageType.TOKEN_UNREACHED.name(), "Время токена истекло"},
            {MessageType.JSON_EXCEPTION.name(), "Ошибка парсинга файла"},
            {TextType.UNKNOWN_MESSAGE.name(), "Неизвестное сообщение от сервера"},
            {TextType.WRITE_TOKEN.name(), "Введите токен"},
            {TextType.MESSAGE_SENDED.name(), "Запрос отправлен"},
            {TextType.WRONG_FORMAT_TOKEN.name(), "Неправильный формат токена"},
            {TextType.WRONG_FORMAT_PORT.name(), "Неправильный формат порта"},
            {TextType.MAX_PORT_SIZE.name(), "Превышен порог"},
            {TextType.CHECK_BUTTON.name(), "Подключиться"},
            {TextType.EXIT_BUTTON.name(), "Выход"},
            {TextType.PORT_LABEL.name(), "Введите порт"},
            {TextType.RUSSIAN.name(), "Русский"},
            {TextType.TURKISH.name(), "Турецкий"},
            {TextType.UKRAINIAN.name(), "Украинский"},
            {TextType.SPANISH_NI.name(), "Испанский"},
            {TextType.WRITE_LOGIN.name(), "Введите логин"},
            {TextType.WRITE_PASSWORD.name(), "Введите пароль"},
            {TextType.LOGIN_BUTTON.name(), "Вход"},
            {TextType.REGISTER_BUTTON.name(), "Регистрация"},
            {TextType.BACK_BUTTON.name(), "Назад"},
            {TextType.LOGIN_LABEL.name(), "Логин"},
            {TextType.PASSWORD_LABEL.name(), "Пароль"},
            {TextType.CHOOSE_OBJECT.name(), "Выберите объект"},
            {TextType.CHOOSE_PATH.name(), "Укажите путь"},
            {TextType.TABLE.name(), "Таблица"},
            {TextType.PANEL.name(), "Графическое изображение"},
            {TextType.WELCOME_LABEL.name(), "Добро пожаловать, "},
            {TextType.CHANGER_LABEL.name(), "Редактор"},
            {TextType.DATE_LABEL.name(), "Дата создания:"},
            {TextType.SIZE_LABEL.name(), "Размер:"},
            {TextType.NAME_LABEL.name(), "Имя:"},
            {TextType.CUP_OF_TEA.name(), "Чашка чая"},
            {TextType.FULLNESS_LABEL.name(), "Заполненность:"},
            {TextType.TEA_TYPE_LABEL.name(), "Тип чая:"},
            {TextType.ADD_BUTTON.name(), "Добавить"},
            {TextType.CHANGE_BUTTON.name(), "Изменить"},
            {TextType.REMOVE_BUTTON.name(), "Удалить"},
            {TextType.REMOVE_ALL_BUTTON.name(), "Удалить все"},
            {TextType.REMOVE_GREATER_BUTTON.name(), "Удалить большие"},
            {TextType.IMPORT_BUTTON.name(), "Импортировать из файла"},
            {TextType.CLASS_COLLECTION_LABEL.name(), "В коллекции хранятся объекты типа: Alice"},
            {TextType.PATH_LABEL.name(), "Путь:"},
            {TextType.COLLECTION_LABEL.name(), "Коллекция"},
            {TextType.COUNT_LABEL.name(), "Количество объектов в коллекции:"},
            {TextType.FILE_NOT_EXIST.name(), "Файл не существует"},
            {TextType.IS_NOT_FILE.name(), "Это не файл"},
            {TextType.CANNOT_READ.name(), "Невозможно считать файл"},
            {TextType.OWNER_LABEL.name(), "Владелец:"},
            {TextType.POLITENESS_LABEL.name(), "Вежливость:"},
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
