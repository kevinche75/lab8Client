import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Receiver  {

    private DatagramChannel channel;
    private CheckConnection checkConnection;
    private LoginAndRegister loginAndRegister;
    private Commands commands;
    private Sender sender;
    private int port;
    private int token;
    private String login;
    private boolean checkConnectionEnabled = false;
    private boolean loginAndRegisterEnabled = false;
    private boolean commandsEnabled = false;

    public Receiver() throws IOException {
       channel = DatagramChannel.open();
       sender = new Sender(channel);
       checkConnection = new CheckConnection(sender, this);
       checkConnectionEnabled = true;
       run();
    }

    public String getLogin() {
        return login;
    }

    public int getToken() {
        return token;
    }   
    
    public void loginBack(){
        loginAndRegister.dispose();
        checkConnection = new CheckConnection(sender, this);
        loginAndRegisterEnabled = false;
        checkConnectionEnabled = true;
    }
    
    public void commandsBack(){
        commands.dispose();
        loginAndRegister = new LoginAndRegister(sender, this);
        loginAndRegisterEnabled = true;
        commandsEnabled = false;
    }

    public void disconnection(){
        if(commandsEnabled){
            commands.dispose();
            commandsEnabled = false;
        }
        if(loginAndRegisterEnabled){
            loginAndRegister.dispose();
            loginAndRegisterEnabled = false;
        }
        checkConnection = new CheckConnection(sender, this);
        checkConnectionEnabled = true;
    }
    
    public void serverChecked(){
        port = checkConnection.getPort();
        checkConnection.dispose();
        loginAndRegister = new LoginAndRegister(sender, this);
    }
    
    public void loginChecked(){
        login = loginAndRegister.getLogin();
        loginAndRegister.dispose();
        commands = new Commands(sender, this);
        loginAndRegisterEnabled = false;
        commandsEnabled = true;
        HashMap<Integer, Three<String,Integer, Alice>> collection = new HashMap<>();
        collection.put(new Integer(12), new Three<String,Integer,Alice>("Dimasik", new Integer(1), new Alice("Алиса", Politeness.POLITE, 1, 1, 1, 10, TeaType.BLACK)));
        collection.put(new Integer(1), new Three<String,Integer,Alice>("Valeron",new Integer(2), new Alice("Alice", Politeness.RUDE, 30, 50, 10, 10, TeaType.GREEN)));
        collection.put(new Integer(15), new Three<String,Integer,Alice>("Valeron",new Integer(2), new Alice("Al", Politeness.POLITE, 70, 80, 3, 10, TeaType.GREEN)));
        commands.initTable(collection);
    }

    private void sendToken(){
        while(true){
            try {
            String result = JOptionPane.showInputDialog(loginAndRegister,"Введите токен");
            int token = Integer.parseInt(result);
            sender.<String>send(MessageType.TOKEN, login, token);
            JOptionPane.showMessageDialog(loginAndRegister, "Запрос отправлен","Info",JOptionPane.PLAIN_MESSAGE);
            return;
        } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(loginAndRegister, "Неправильный формат токена","Info",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    
    public void run() {
            while (true) {
                try {
                    ByteBuffer buffer = ByteBuffer.wrap(new byte[64 * 1024]);
                    channel.receive(buffer);
                    try (ObjectInputStream receivedstream = new ObjectInputStream(new ByteArrayInputStream(buffer.array()))) {
                        ServerMessage message = (ServerMessage) receivedstream.readObject();
                        switch (message.getSpecialWord()) {
                            case DISCONNECTION:
                                disconnection();
                                JOptionPane.showMessageDialog(checkConnection, "Сервер недоступен","Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case COMMAND_UNDONE:
                                if(commandsEnabled) 
                                    JOptionPane.showMessageDialog(commands, "Комманда не выполнена","Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case MAX_NUMBER:
                                if(loginAndRegisterEnabled)
                                    JOptionPane.showMessageDialog(loginAndRegister, "Максимальное число пользователей","Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case CONNECTION:
                                serverChecked();
                                break;
                            case TRUE_LOGIN:
                                if(loginAndRegisterEnabled)
                                    loginChecked();
                                break;
                            case FALSE_LOGIN:
                                  if(loginAndRegisterEnabled) 
                                      JOptionPane.showMessageDialog(loginAndRegister, "Неправильный логин или пароль","Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case FALSE_REGISTER_LOGIN:
                                  if(loginAndRegisterEnabled) 
                                      JOptionPane.showMessageDialog(loginAndRegister, "Неправильный формат логина","Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case ALREADY_EXIST:
                                 if(loginAndRegisterEnabled) 
                                     JOptionPane.showMessageDialog(loginAndRegister, "Пользователь с таким именем уже существует","Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case TRUE_REGISTER_LOGIN:
                                  if(loginAndRegisterEnabled)
                                      JOptionPane.showMessageDialog(loginAndRegister, "Вам на почту отправлен уникальный код","Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case TOKEN_IS_ACTIVE:
                                if(loginAndRegisterEnabled) 
                                      JOptionPane.showMessageDialog(loginAndRegister, "Такой пользователь уже существует, либо токен для этого пользователя ещё активен","Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case TRUE_REGISTRATION:
                                if(loginAndRegisterEnabled) 
                                      JOptionPane.showMessageDialog(loginAndRegister, "Вы зарегистрированы","Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case FALSE_REGISTRATION:
                               if(loginAndRegisterEnabled)
                                   JOptionPane.showMessageDialog(loginAndRegister, "Неправильно указан уникальный код","Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case ERROR:
                                if(loginAndRegisterEnabled)
                                   JOptionPane.showMessageDialog(loginAndRegister, "Ошибка получения данных","Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case TOKEN_UNREACHED:
                                if(loginAndRegisterEnabled){
                                    JOptionPane.showMessageDialog(loginAndRegister, "Время токена истекло","Info",JOptionPane.PLAIN_MESSAGE);
                                    }
                            break;
                            case COLLECTION:
                                if(commandsEnabled){
                                    HashMap<Integer, Three<String, Integer, Alice>> collection = (HashMap<Integer, Three<String, Integer, Alice>>) message.getArgument();
                                    commands.initTable(collection);
                                }
                                break;
                            case ADD_ROW:
                                if(commandsEnabled){
                                    new Thread(()->{
                                        Pair<Integer, Three<String, Integer, Alice>> element = (Pair<Integer, Three<String, Integer, Alice>>) message.getArgument();
                                        commands.addRow(element);
                                    }).start();
                                }
                                break;
                            case ADD_ROWS:
                                if(commandsEnabled){
                                    new Thread(()->{
                                        HashMap<Integer, Three<String, Integer, Alice>> collection = (HashMap<Integer, Three<String, Integer, Alice>>) message.getArgument();
                                        commands.addRows(collection);}).start();
                                }
                                break;
                            case REMOVE_ROW:
                                if(commandsEnabled){
                                    new Thread(()->{
                                        Integer id = (Integer) message.getArgument();
                                        commands.removeRow(id);}).start();
                                }
                                break;
                            case REMOVE_ROWS:
                                if(commandsEnabled){
                                    new Thread(()->{
                                        ArrayList<Integer> list = (ArrayList<Integer>) message.getArgument();
                                        commands.removeRows(list);}).start();
                                }
                                break;
                            case CHANGE_ROW:
                                if(commandsEnabled){
                                    new Thread(()->{
                                        Pair<Integer, Three<String, Integer, Alice>> element = (Pair<Integer, Three<String, Integer, Alice>>) message.getArgument();
                                        commands.changeRow(element);}).start();
                                }
                                break;
                            case JSONEXCEPTION:
                                if(commandsEnabled)
                                    JOptionPane.showMessageDialog(commands, "Ошибка парсинга файла","Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            default:
//                                System.out.println(message.getMessage());
                        }
                    } catch (ClassNotFoundException e) {
                        System.out.println("===\nНеизвестное сообщение от сервера");
                    } catch (ClassCastException e){
                        System.out.println("===\nОшибка получения данных");
                    }
                } catch (IOException e) {
                    System.out.println("===\nНепредвиденная ошибка приёма пакетов");
                }
            }


    }
}
