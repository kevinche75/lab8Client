import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author kevin
 */
public class Commands extends javax.swing.JFrame {

   private Sender sender;
   private Receiver receiver;
   private int token;
   private String login;
   private HashMap<Integer, Three<String, Integer, Alice>> collection;
   private Integer currentObject;
   private boolean selection = false;
   private HashMap<String, RowFilter<Object,Object>> andFilters = new HashMap<>();
   private PanelForPainting panelForPainting;

   public void setCurrentObject(Integer id){
       currentObject = id;
   }
    
    public Commands(Sender sender, Receiver receiver) {
        this.sender = sender;
        this.receiver = receiver;
        token = receiver.getToken();
        login = receiver.getLogin();
        initComponents();
        loginLabel.setText(login);
        panelForPainting = new PanelForPainting(this);
        jTabbedPane1.add(panelForPainting);
        setVisible(true);
    }
    
    public void initTable(HashMap<Integer, Three<String, Integer, Alice>> collection){
        this.collection = collection;
        table.getTableHeader().setReorderingAllowed(false);
        removeButton.setEnabled(false);
        changeButton.setEnabled(false);
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        collection.forEach((k,v)->{
             model.addRow(new Object[]{k, v.getKey(), v.getElement().getName(), v.getElement().getPoliteness(),
                 v.getElement().getSize(), v.getElement().getX(), v.getElement().getY(), v.getElement().getDate(),
                 v.getElement().getfullness(), v.getElement().getTeaType()});
        }
        );
        panelForPainting.addAlices(collection);
        countLabel.setText(new Integer(collection.size()).toString());
    }
    
    public void addRow(Pair<Integer, Three<String, Integer, Alice>> element){
        collection.put(element.getKey(), element.getValue());
        DefaultTableModel model = (DefaultTableModel)table.getModel();
            model.addRow(new Object[]{element.getKey(), element.getValue().getKey(), element.getValue().getElement().getName(),
                element.getValue().getElement().getPoliteness(), element.getValue().getElement().getSize(), 
                element.getValue().getElement().getX(), element.getValue().getElement().getY(),
                element.getValue().getElement().getDate(),
                element.getValue().getElement().getfullness(), element.getValue().getElement().getTeaType()
            });
            panelForPainting.addAlice(element);
        countLabel.setText(new Integer(collection.size()).toString());
    }
    
    public void addRows(HashMap<Integer, Three<String, Integer, Alice>> collection){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        collection.forEach((k,v)->{
            collection.put(k, v);
             model.addRow(new Object[]{k, v.getKey(), v.getElement().getName(), v.getElement().getPoliteness(),
                 v.getElement().getSize(), v.getElement().getX(), v.getElement().getY(), v.getElement().getDate(),
                 v.getElement().getfullness(), v.getElement().getTeaType()});
        }
        );
        panelForPainting.addAlices(collection);
        countLabel.setText(new Integer(collection.size()).toString());
    }
    
    public void removeRow(Integer id){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        for(int count= 1; count<= model.getRowCount(); count++){
            Integer currentID = (Integer)model.getValueAt(count, 0);
            if(id.equals(currentID)){
                model.removeRow(count);
                break;
            }
        }
        collection.remove(id);
        panelForPainting.removeAlice(id);
        countLabel.setText(new Integer(collection.size()).toString());
    }
    
    public void removeRows(ArrayList<Integer> list){
        list.forEach(e -> {
            removeRow(e);
            collection.remove(e);
        });
        panelForPainting.removeAlices(list);
        countLabel.setText(new Integer(collection.size()).toString());
    }
    
    public void changeRow(Pair<Integer, Three<String, Integer, Alice>> element){
         DefaultTableModel model = (DefaultTableModel)table.getModel();
        for(int count= 1; count<= model.getRowCount(); count++){
            Integer currentID = (Integer)model.getValueAt(count, 0);
            if(element.getKey().equals(currentID)){
                model.setValueAt(element.getValue().getElement().getName(), count, 2);
                model.setValueAt(element.getValue().getElement().getPoliteness(), count, 3);
                model.setValueAt(element.getValue().getElement().getSize(), count, 4);
                model.setValueAt(element.getValue().getElement().getX(), count, 5);
                model.setValueAt(element.getValue().getElement().getY(), count, 6);
                model.setValueAt(element.getValue().getElement().getDate(),count, 7);
                model.setValueAt(element.getValue().getElement().getfullness(), count, 8);
                model.setValueAt(element.getValue().getElement().getTeaType(), count, 9);
                break;
            }
        }
        collection.put(element.getKey(), element.getValue());
        panelForPainting.changeAlice(element.getKey(), element.getValue().getElement());
        countLabel.setText(new Integer(collection.size()).toString());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        helloLabel = new javax.swing.JLabel();
        languageComboBox = new javax.swing.JComboBox();
        loginLabel = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        changerLabel = new javax.swing.JLabel();
        messageDateLabel = new javax.swing.JLabel();
        messageOwnerLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        ownerLabel = new javax.swing.JLabel();
        messagePolitenessLabel = new javax.swing.JLabel();
        politenessComboBox = new javax.swing.JComboBox();
        messageSizeLabel = new javax.swing.JLabel();
        sizeSlider = new javax.swing.JSlider();
        messageXLabel = new javax.swing.JLabel();
        messageYLabel = new javax.swing.JLabel();
        xSlider = new javax.swing.JSlider();
        ySlider = new javax.swing.JSlider();
        messageLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        messageCupLabel = new javax.swing.JLabel();
        messageFullnessLabel = new javax.swing.JLabel();
        fullnessSlider = new javax.swing.JSlider();
        teeTypeComboBox = new javax.swing.JComboBox();
        messageTeaTypeLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        changeButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        removeAllButton = new javax.swing.JButton();
        removeGreaterButton = new javax.swing.JButton();
        importButton = new javax.swing.JButton();
        pathTextField = new javax.swing.JTextField();
        messagePathLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        classCollectionLabel = new javax.swing.JLabel();
        collectionLabel = new javax.swing.JLabel();
        countmessageLabel = new javax.swing.JLabel();
        countLabel = new javax.swing.JLabel();
        idFilter = new javax.swing.JTextField();
        ownerFilter = new javax.swing.JTextField();
        nameFilter = new javax.swing.JTextField();
        politenessFilter = new javax.swing.JComboBox();
        xFilter = new javax.swing.JTextField();
        yFilter = new javax.swing.JTextField();
        dateFilter = new javax.swing.JTextField();
        fullnessFilter = new javax.swing.JTextField();
        teaTypeFilter = new javax.swing.JComboBox();
        sizeFilter = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dimasik.System");
        setResizable(false);

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Owner", "name", "Politeness", "Size", "X", "Y", "Date", "Fullness, Cup", "TeaType, Cup"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setToolTipText("");
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        jTabbedPane1.addTab("Таблица", jScrollPane2);

        helloLabel.setText("Добро пожаловать, ");

        languageComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Русский", "Украинский", "Турецкий", "Испанский" }));
        languageComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageComboBoxActionPerformed(evt);
            }
        });

        exitButton.setText("Выход");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        changerLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        changerLabel.setText("Редактор");
        changerLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        messageDateLabel.setText("Дата создания:");

        messageOwnerLabel.setText("Владелец:");

        messagePolitenessLabel.setText("Вежливость:");

        politenessComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "POLITE", "RUDE" }));

        messageSizeLabel.setText("Размер:");

        sizeSlider.setMajorTickSpacing(1);
        sizeSlider.setMaximum(10);
        sizeSlider.setMinimum(1);
        sizeSlider.setPaintLabels(true);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setSnapToTicks(true);
        sizeSlider.setToolTipText("");
        sizeSlider.setValue(5);

        messageXLabel.setText("X:");

        messageYLabel.setText("Y:");

        xSlider.setMajorTickSpacing(10);
        xSlider.setPaintLabels(true);

        ySlider.setMajorTickSpacing(10);
        ySlider.setPaintLabels(true);

        messageLabel.setText("Имя:");

        messageCupLabel.setText(" Чашка чая");

        messageFullnessLabel.setText("Заполненность:");

        fullnessSlider.setMajorTickSpacing(10);
        fullnessSlider.setPaintLabels(true);

        teeTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GREEN", "BLACK", "RED" }));

        messageTeaTypeLabel.setText("Тип чая:");

        addButton.setText("Добавить");
        addButton.setPreferredSize(new java.awt.Dimension(90, 25));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        changeButton.setText("Изменить");
        changeButton.setPreferredSize(new java.awt.Dimension(90, 25));
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Удалить");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        removeAllButton.setText("Удалить все");
        removeAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllButtonActionPerformed(evt);
            }
        });

        removeGreaterButton.setText("Удалить большие");
        removeGreaterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeGreaterButtonActionPerformed(evt);
            }
        });

        importButton.setText("Импортировать из файла");
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        messagePathLabel.setText("Путь:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(messageCupLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(messageXLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(messageYLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(messageFullnessLabel)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(messageTeaTypeLabel)
                .addGap(18, 18, 18)
                .addComponent(teeTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(removeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(changeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(importButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeGreaterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(messagePathLabel)
                .addGap(18, 18, 18)
                .addComponent(pathTextField)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fullnessSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ySlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sizeSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(xSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(messageSizeLabel)
                                    .addComponent(messagePolitenessLabel)
                                    .addComponent(messageOwnerLabel)
                                    .addComponent(messageDateLabel)
                                    .addComponent(messageLabel))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(politenessComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(nameTextField))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(ownerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(changerLabel)
                        .addGap(95, 95, 95))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(changerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(messageDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(messageOwnerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ownerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(messageLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messagePolitenessLabel)
                    .addComponent(politenessComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(messageSizeLabel)
                .addGap(5, 5, 5)
                .addComponent(sizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(messageXLabel)
                .addGap(1, 1, 1)
                .addComponent(xSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(messageYLabel)
                .addGap(2, 2, 2)
                .addComponent(ySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(messageCupLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageFullnessLabel)
                .addGap(8, 8, 8)
                .addComponent(fullnessSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teeTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(messageTeaTypeLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeAllButton)
                    .addComponent(removeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeGreaterButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(importButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(messagePathLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pathTextField))
                .addContainerGap())
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        classCollectionLabel.setText("В коллекции хранятся объекты типа: Alice");

        collectionLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        collectionLabel.setText("Коллекция");

        countmessageLabel.setText("Количество объектов в коллекции:");

        idFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idFilterKeyReleased(evt);
            }
        });

        ownerFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ownerFilterKeyReleased(evt);
            }
        });

        nameFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameFilterKeyReleased(evt);
            }
        });

        politenessFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "POLITE", "RUDE" }));
        politenessFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                politenessFilterActionPerformed(evt);
            }
        });

        xFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                xFilterKeyReleased(evt);
            }
        });

        yFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                yFilterKeyReleased(evt);
            }
        });

        dateFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dateFilterKeyReleased(evt);
            }
        });

        fullnessFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fullnessFilterKeyReleased(evt);
            }
        });

        teaTypeFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "GREEN", "BLACK", "RED" }));
        teaTypeFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teaTypeFilterActionPerformed(evt);
            }
        });

        sizeFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sizeFilterKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(languageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(helloLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(loginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(exitButton))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(collectionLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(classCollectionLabel)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(countmessageLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(countLabel)))))
                                .addGap(89, 89, 89))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(xFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(yFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fullnessFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(teaTypeFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(17, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ownerFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(politenessFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sizeFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(collectionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(classCollectionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(countmessageLabel)
                                    .addComponent(countLabel)))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(languageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(helloLabel)
                                    .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exitButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ownerFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(politenessFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fullnessFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(teaTypeFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sizeFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jTabbedPane1)
                        .addGap(8, 8, 8))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private Alice getAlice(){
        String name = nameTextField.getText();
        String politenessName = (String)politenessComboBox.getSelectedItem();
        Politeness politeness;
        if(politenessName.equals("POLITE")){
            politeness = Politeness.POLITE;
        } else {
            politeness = Politeness.RUDE;
        }
        int size = sizeSlider.getValue();
        int x = xSlider.getValue();
        int y = ySlider.getValue();
        int fullness = fullnessSlider.getValue();
        String teaTypeName = (String)teeTypeComboBox.getSelectedItem();
        TeaType teaType;
        if(teaTypeName.equals("GREEN")){
            teaType = TeaType.GREEN;
        } else {
        if(teaTypeName.equals("BLACK")){
            teaType = TeaType.BLACK;
        } else
            teaType = TeaType.RED;
        }
        return new Alice(name, politeness, size, x, y ,fullness, teaType);
    }
    
    private void languageComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_languageComboBoxActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        sender.send(MessageType.EXIT, null, token);
        receiver.commandsBack();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        sender.<Alice>send(MessageType.ADD, getAlice(), token);
    }//GEN-LAST:event_addButtonActionPerformed

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        if(currentObject != null){
            sender.<Pair<Integer, Alice>>send(MessageType.CHANGE, new Pair<>(currentObject, getAlice()), token);
        } else {
            JOptionPane.showMessageDialog(this, "Выберите объект","Info",JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_changeButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        if(currentObject != null){
            sender.<Integer>send(MessageType.REMOVE, currentObject, token);
        } else {
            JOptionPane.showMessageDialog(this, "Выберите объект","Info",JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void removeAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAllButtonActionPerformed
            sender.<Alice>send(MessageType.REMOVE_ALL, getAlice(), token);
    }//GEN-LAST:event_removeAllButtonActionPerformed

    private void removeGreaterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeGreaterButtonActionPerformed
        sender.<Alice>send(MessageType.REMOVE_GREATER, getAlice(), token);
    }//GEN-LAST:event_removeGreaterButtonActionPerformed

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        if(pathTextField.getText()==null||pathTextField.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Укажите путь","Info",JOptionPane.PLAIN_MESSAGE);
        } else {
            try{
                sender.<String>send(MessageType.IMPORT, Reader.justReadFile(pathTextField.getText()), token);
            } catch(FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Info", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_importButtonActionPerformed

    public void setValues(){
        Alice alice = collection.get(currentObject).getElement();
        dateLabel.setText(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(alice.getDate()));
        ownerLabel.setText(collection.get(currentObject).getKey());
        nameTextField.setText(alice.getName());
        politenessComboBox.setSelectedItem(alice.getPoliteness().toString());
        sizeSlider.setValue(alice.getSize());
        xSlider.setValue(alice.getX());
        ySlider.setValue(alice.getY());
        fullnessSlider.setValue(alice.getfullness());
        teeTypeComboBox.setSelectedItem(alice.getTeaType().toString());
        if(!login.equals(collection.get(currentObject).getKey())){
            setButtons(false);
        } else {
            setButtons(true);
        }
    }

    public void setButtons(boolean click){
        changeButton.setEnabled(click);
        removeButton.setEnabled(click);
    }
    
    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
        if(!selection){
            selection = true;
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        int index = table.getSelectedRow();
        currentObject = (Integer)model.getValueAt(table.convertRowIndexToModel(index), 0);
        setValues();
        } else {
            selection = false;
            table.getSelectionModel().clearSelection();
            changeButton.setEnabled(false);
            removeButton.setEnabled(false);
        }
    }//GEN-LAST:event_tableMousePressed

    private void politenessFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_politenessFilterActionPerformed
        String politeness = (String) politenessFilter.getSelectedItem();
        switch(politeness){
            case "All":
                andFilters.remove("Politeness");
                break;
            case "POLITE":
            case "RUDE":
                andFilters.put("Politeness", new RowFilter<Object, Object>() {
      @Override
      public boolean include(RowFilter.Entry entry) {
        Politeness id = (Politeness) entry.getValue(3);
        return politeness.equals(id.name());
      }
    });
                break;
        }
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) table.getModel()));
            sorter.setRowFilter(RowFilter.andFilter(new ArrayList<RowFilter<Object,Object>>(andFilters.values())));
            table.setRowSorter(sorter);
    }//GEN-LAST:event_politenessFilterActionPerformed

    private void idFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idFilterKeyReleased
        if(idFilter.getText()==null||idFilter.getText().equals("")){
            andFilters.remove("ID");
        } else {
            andFilters.put("ID", new RowFilter<Object, Object>() {
      @Override
      public boolean include(RowFilter.Entry entry) {
        Integer id = (Integer) entry.getValue(0);
        return id.equals(new Integer(idFilter.getText()));
      }
    });
        }
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) table.getModel()));
            sorter.setRowFilter(RowFilter.andFilter(new ArrayList<RowFilter<Object,Object>>(andFilters.values())));
            table.setRowSorter(sorter);
    }//GEN-LAST:event_idFilterKeyReleased

    private void ownerFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ownerFilterKeyReleased
        if(ownerFilter.getText()==null||ownerFilter.getText().equals("")){
            andFilters.remove("Owner");
        } else {
            andFilters.put("Owner", new RowFilter<Object, Object>() {
      @Override
      public boolean include(RowFilter.Entry entry) {
        String id = (String) entry.getValue(1);
        return id.startsWith(ownerFilter.getText());
      }
    });
        }
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) table.getModel()));
            sorter.setRowFilter(RowFilter.andFilter(new ArrayList<RowFilter<Object,Object>>(andFilters.values())));
            table.setRowSorter(sorter);
    }//GEN-LAST:event_ownerFilterKeyReleased

    private void nameFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFilterKeyReleased
        if(nameFilter.getText()==null||nameFilter.getText().equals("")){
            andFilters.remove("Name");
        } else {
            andFilters.put("Name", new RowFilter<Object, Object>() {
      @Override
      public boolean include(RowFilter.Entry entry) {
        String id = (String) entry.getValue(2);
        return id.startsWith(nameFilter.getText());
      }
    });
        }
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) table.getModel()));
            sorter.setRowFilter(RowFilter.andFilter(new ArrayList<RowFilter<Object,Object>>(andFilters.values())));
            table.setRowSorter(sorter);
    }//GEN-LAST:event_nameFilterKeyReleased

    private void xFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xFilterKeyReleased
        if(xFilter.getText()==null||xFilter.getText().equals("")){
            andFilters.remove("X");
        } else {
            andFilters.put("X", new RowFilter<Object, Object>() {
      @Override
      public boolean include(RowFilter.Entry entry) {
        Integer id = (Integer) entry.getValue(5);
        return id.equals(new Integer(xFilter.getText()));
      }
    });
        }
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) table.getModel()));
            sorter.setRowFilter(RowFilter.andFilter(new ArrayList<RowFilter<Object,Object>>(andFilters.values())));
            table.setRowSorter(sorter);
    }//GEN-LAST:event_xFilterKeyReleased

    private void yFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yFilterKeyReleased
        if(yFilter.getText()==null||yFilter.getText().equals("")){
            andFilters.remove("Y");
        } else {
            andFilters.put("Y", new RowFilter<Object, Object>() {
      @Override
      public boolean include(RowFilter.Entry entry) {
        Integer id = (Integer) entry.getValue(6);
        return id.equals(new Integer(yFilter.getText()));
      }
    });
        }
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) table.getModel()));
            sorter.setRowFilter(RowFilter.andFilter(new ArrayList<RowFilter<Object,Object>>(andFilters.values())));
            table.setRowSorter(sorter);
    }//GEN-LAST:event_yFilterKeyReleased

    private void dateFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateFilterKeyReleased
        if(dateFilter.getText()==null||dateFilter.getText().equals("")){
            andFilters.remove("Date");
        } else {
            andFilters.put("Date", new RowFilter<Object, Object>() {
      @Override
      public boolean include(RowFilter.Entry entry) {
          ZonedDateTime id = (ZonedDateTime) entry.getValue(7);
        return id.toString().startsWith(dateFilter.getText());
      }
    });
        }
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) table.getModel()));
            sorter.setRowFilter(RowFilter.andFilter(new ArrayList<RowFilter<Object,Object>>(andFilters.values())));
            table.setRowSorter(sorter);
    }//GEN-LAST:event_dateFilterKeyReleased

    private void fullnessFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fullnessFilterKeyReleased
        if(fullnessFilter.getText()==null||fullnessFilter.getText().equals("")){
            andFilters.remove("Fullness");
        } else {
            andFilters.put("Fullness", new RowFilter<Object, Object>() {
      @Override
      public boolean include(RowFilter.Entry entry) {
        Integer id = (Integer) entry.getValue(8);
        return id.equals(new Integer(fullnessFilter.getText()));
      }
    });
        }
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) table.getModel()));
            sorter.setRowFilter(RowFilter.andFilter(new ArrayList<RowFilter<Object,Object>>(andFilters.values())));
            table.setRowSorter(sorter);
    }//GEN-LAST:event_fullnessFilterKeyReleased

    private void sizeFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sizeFilterKeyReleased
        if(sizeFilter.getText()==null||sizeFilter.getText().equals("")){
            andFilters.remove("Size");
        } else {
            andFilters.put("Size", new RowFilter<Object, Object>() {
      @Override
      public boolean include(RowFilter.Entry entry) {
        Integer id = (Integer) entry.getValue(4);
        return id.equals(new Integer(sizeFilter.getText()));
      }
    });
        }
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) table.getModel()));
            sorter.setRowFilter(RowFilter.andFilter(new ArrayList<RowFilter<Object,Object>>(andFilters.values())));
            table.setRowSorter(sorter);
    }//GEN-LAST:event_sizeFilterKeyReleased

    private void teaTypeFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teaTypeFilterActionPerformed
        String politeness = (String) teaTypeFilter.getSelectedItem();
        switch(politeness){
            case "All":
                andFilters.remove("TeaType");
                break;
            case "GREEN":
            case "BLACK":
            case "RED":
                andFilters.put("TeaType", new RowFilter<Object, Object>() {
      @Override
      public boolean include(RowFilter.Entry entry) {
        TeaType id = (TeaType) entry.getValue(9);
        return politeness.equals(id.name());
      }
    });
                break;
        }
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) table.getModel()));
            sorter.setRowFilter(RowFilter.andFilter(new ArrayList<RowFilter<Object,Object>>(andFilters.values())));
            table.setRowSorter(sorter);
    }//GEN-LAST:event_teaTypeFilterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton changeButton;
    private javax.swing.JLabel changerLabel;
    private javax.swing.JLabel classCollectionLabel;
    private javax.swing.JLabel collectionLabel;
    private javax.swing.JLabel countLabel;
    private javax.swing.JLabel countmessageLabel;
    private javax.swing.JTextField dateFilter;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField fullnessFilter;
    private javax.swing.JSlider fullnessSlider;
    private javax.swing.JLabel helloLabel;
    private javax.swing.JTextField idFilter;
    private javax.swing.JButton importButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox languageComboBox;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel messageCupLabel;
    private javax.swing.JLabel messageDateLabel;
    private javax.swing.JLabel messageFullnessLabel;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel messageOwnerLabel;
    private javax.swing.JLabel messagePathLabel;
    private javax.swing.JLabel messagePolitenessLabel;
    private javax.swing.JLabel messageSizeLabel;
    private javax.swing.JLabel messageTeaTypeLabel;
    private javax.swing.JLabel messageXLabel;
    private javax.swing.JLabel messageYLabel;
    private javax.swing.JTextField nameFilter;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField ownerFilter;
    private javax.swing.JLabel ownerLabel;
    private javax.swing.JTextField pathTextField;
    private javax.swing.JComboBox politenessComboBox;
    private javax.swing.JComboBox politenessFilter;
    private javax.swing.JButton removeAllButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton removeGreaterButton;
    private javax.swing.JTextField sizeFilter;
    private javax.swing.JSlider sizeSlider;
    private javax.swing.JTable table;
    private javax.swing.JComboBox teaTypeFilter;
    private javax.swing.JComboBox teeTypeComboBox;
    private javax.swing.JTextField xFilter;
    private javax.swing.JSlider xSlider;
    private javax.swing.JTextField yFilter;
    private javax.swing.JSlider ySlider;
    // End of variables declaration//GEN-END:variables
}
