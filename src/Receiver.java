import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
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
    private Locale locale = new Locale("ru");
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("Resources",locale);

    public Receiver() throws IOException {
       channel = DatagramChannel.open();
       sender = new Sender(channel);
       checkConnection = new CheckConnection(sender, this);
       checkConnectionEnabled = true;
       run();
    }

    public int getLocale(){
        switch (locale.getLanguage()){
            case "ru":
                return 0;
            case "tr":
                return 1;
            case "uk":
                return 2;
            case "es":
                return 3;
                default:
                    return 0;
        }
    }

    public void setLocale(String locale){
        this.locale = new Locale(locale);
        resourceBundle = ResourceBundle.getBundle("Resources", this.locale);
    }

    public void setLocale(String locale, String country){
        this.locale = new Locale(locale, country);
        resourceBundle = ResourceBundle.getBundle("Resources", this.locale);
    }

    public ResourceBundle getResource(){
        return resourceBundle;
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
                if(loginAndRegisterEnabled) {
                    String result = JOptionPane.showInputDialog(loginAndRegister, resourceBundle.getString(TextType.WRITE_TOKEN.name()));
                    int token = Integer.parseInt(result);
                    sender.<String>send(MessageType.TOKEN, login, token);
                } else return;
                if(loginAndRegisterEnabled)
            JOptionPane.showMessageDialog(loginAndRegister, resourceBundle.getString(TextType.MESSAGE_SENDED.name()),"Info",JOptionPane.PLAIN_MESSAGE);
                else return;
            return;
        } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(loginAndRegister, resourceBundle.getString(TextType.WRONG_FORMAT_TOKEN.name()),"Info",JOptionPane.PLAIN_MESSAGE);
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
                                JOptionPane.showMessageDialog(checkConnection, resourceBundle.getString(MessageType.DISCONNECTION.name()),"Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case COMMAND_UNDONE:
                                if(commandsEnabled) 
                                    JOptionPane.showMessageDialog(commands, resourceBundle.getString(MessageType.COMMAND_UNDONE.name()),"Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case MAX_NUMBER:
                                if(loginAndRegisterEnabled)
                                    JOptionPane.showMessageDialog(loginAndRegister, resourceBundle.getString(MessageType.MAX_NUMBER.name()),"Info",JOptionPane.PLAIN_MESSAGE);
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
                                      JOptionPane.showMessageDialog(loginAndRegister, resourceBundle.getString(MessageType.FALSE_LOGIN.name()),"Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case FALSE_REGISTER_LOGIN:
                                  if(loginAndRegisterEnabled) 
                                      JOptionPane.showMessageDialog(loginAndRegister, resourceBundle.getString(MessageType.FALSE_REGISTER_LOGIN.name()),"Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case ALREADY_EXIST:
                                 if(loginAndRegisterEnabled) 
                                     JOptionPane.showMessageDialog(loginAndRegister, resourceBundle.getString(MessageType.ALREADY_EXIST.name()),"Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case TRUE_REGISTER_LOGIN:
                                  if(loginAndRegisterEnabled) {
                                      JOptionPane.showMessageDialog(loginAndRegister, resourceBundle.getString(MessageType.TRUE_REGISTER_LOGIN.name()), "Info", JOptionPane.PLAIN_MESSAGE);
                                      sendToken();
                                  }
                                break;
                            case TOKEN_IS_ACTIVE:
                                if(loginAndRegisterEnabled) 
                                      JOptionPane.showMessageDialog(loginAndRegister, resourceBundle.getString(MessageType.TOKEN_IS_ACTIVE.name()),"Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case TRUE_REGISTRATION:
                                if(loginAndRegisterEnabled) 
                                      JOptionPane.showMessageDialog(loginAndRegister, resourceBundle.getString(MessageType.TRUE_REGISTRATION.name()),"Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case FALSE_REGISTRATION:
                               if(loginAndRegisterEnabled)
                                   JOptionPane.showMessageDialog(loginAndRegister, resourceBundle.getString(MessageType.FALSE_REGISTRATION.name()),"Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case ERROR:
                                if(loginAndRegisterEnabled)
                                   JOptionPane.showMessageDialog(loginAndRegister, resourceBundle.getString(MessageType.ERROR.name()),"Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            case TOKEN_UNREACHED:
                                if(loginAndRegisterEnabled){
                                    JOptionPane.showMessageDialog(loginAndRegister, resourceBundle.getString(MessageType.TOKEN_UNREACHED.name()),"Info",JOptionPane.PLAIN_MESSAGE);
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
                            case JSON_EXCEPTION:
                                if(commandsEnabled)
                                    JOptionPane.showMessageDialog(commands, resourceBundle.getString(MessageType.JSON_EXCEPTION.name()),"Info",JOptionPane.PLAIN_MESSAGE);
                                break;
                            default:
//                                System.out.println(message.getMessage());
                        }
                    } catch (ClassNotFoundException e) {
                        JOptionPane.showMessageDialog(loginAndRegister, resourceBundle.getString(TextType.UNKNOWN_MESSAGE.name()),"Info",JOptionPane.PLAIN_MESSAGE);
                    } catch (ClassCastException e){
                        JOptionPane.showMessageDialog(loginAndRegister, resourceBundle.getString(MessageType.ERROR.name()),"Info",JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(loginAndRegister, resourceBundle.getString(MessageType.ERROR.name()),"Info",JOptionPane.PLAIN_MESSAGE);
                }
            }


    }
}
