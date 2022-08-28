import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.text.DefaultStyledDocument;


public class Notepad extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menuFile, menuEdit, menuAbout;

    private JMenuItem itemNewFile, itemOpen, itemSave, itemExit, itemCut, itemCopy, itemPaste, itemAbout;
    private JToolBar toolBar;

    private JButton butNewFile, butOpen, butSave, butExit, butCut, butCopy, butPaste, butAbout;
    private JTextPane textPane;
    private JLabel label;
    private JFileChooser fileChooser;
    private JScrollPane scrollPane;


    public Notepad() {

        menuBar = new JMenuBar();

        menuFile = new JMenu("file");
        menuEdit = new JMenu("edit");
        menuAbout = new JMenu("about");
        itemNewFile = new JMenuItem("newfile");
        itemNewFile.addActionListener(this);
        itemNewFile.setActionCommand("newFile");
        itemOpen = new JMenuItem("open");
        itemOpen.addActionListener(this);
        itemOpen.setActionCommand("open");
        itemSave = new JMenuItem(" Save");
        itemSave.addActionListener(this);
        itemSave.setActionCommand("save");
        itemExit = new JMenuItem("exit");
        itemExit.addActionListener(this);
        itemExit.setActionCommand("exit");
        itemCut = new JMenuItem("cut");
        itemCut.addActionListener(this);
        itemCut.setActionCommand("cut");
        itemCopy = new JMenuItem("copy");
        itemCopy.addActionListener(this);
        itemCopy.setActionCommand("copy");
        itemPaste = new JMenuItem("past");
        itemPaste.addActionListener(this);
        itemPaste.setActionCommand("paste");
        itemAbout = new JMenuItem("about");
        itemAbout.addActionListener(this);
        itemAbout.setActionCommand("about");

        menuFile.add(itemNewFile);
        menuFile.add(itemOpen);
        menuFile.add(itemExit);
        menuFile.add(itemSave);

        menuEdit.add(itemCut);
        menuEdit.add(itemCopy);
        menuEdit.add(itemPaste);

        menuAbout.add(itemAbout);

        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuAbout);
        this.setJMenuBar(menuBar);

        toolBar = new JToolBar();

        butNewFile = new JButton("newfile");
        butNewFile.addActionListener(this);
        butNewFile.setActionCommand("newFile");
        butOpen = new JButton("open");
        butOpen.addActionListener(this);
        butOpen.setActionCommand("open");
        butSave = new JButton("save");
        butSave.addActionListener(this);
        butSave.setActionCommand("save");
        butExit = new JButton("exit");
        butExit.addActionListener(this);
        butExit.setActionCommand("exit");
        butCut = new JButton("cut");
        butCut.addActionListener(this);
        butCut.setActionCommand("cut");
        butCopy = new JButton("copy");
        butCopy.addActionListener(this);
        butCopy.setActionCommand("copy");
        butPaste = new JButton("coppy");
        butPaste.addActionListener(this);
        butPaste.setActionCommand("paste");
        butAbout = new JButton("about");
        butAbout.addActionListener(this);
        butAbout.setActionCommand("about");

        toolBar.add(butNewFile);
        toolBar.add(butOpen);
        toolBar.add(butSave);
        toolBar.add(butExit);
        toolBar.add(butCut);
        toolBar.add(butCopy);
        toolBar.add(butPaste);
        toolBar.add(butAbout);


        fileChooser = new JFileChooser();

        scrollPane = new JScrollPane(textPane);

        Container container = getContentPane();
        container.add(toolBar, BorderLayout.NORTH);
        container.add(scrollPane, BorderLayout.CENTER);
        container.add(label, BorderLayout.SOUTH);


        this.setTitle("Notepad");
        this.setSize(600, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;//
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setLocation((width - 500) / 2, (height - 400) / 2);//
        this.setVisible(true);//
        this.setResizable(true);//
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("newFile")) {
            textPane.setDocument(new DefaultStyledDocument());//
        } else if (e.getActionCommand().equals("open")) {
            int i = fileChooser.showOpenDialog(Notepad.this); //
            if (i == JFileChooser.APPROVE_OPTION) { //
                File f = fileChooser.getSelectedFile(); //
                try {
                    InputStream is = new FileInputStream(f); //
                    textPane.read(is, "d"); //
                } catch (Exception ex) {
                    ex.printStackTrace(); //
                }
            }
        } else if (e.getActionCommand().equals("save")) {
            int i = fileChooser.showSaveDialog(Notepad.this); //
            if (i == JFileChooser.APPROVE_OPTION) { //
                File f = fileChooser.getSelectedFile(); //
                try {
                    FileOutputStream out = new FileOutputStream(f); //
                    out.write(textPane.getText().getBytes()); //
                } catch (Exception ex) {
                    ex.printStackTrace(); //
                }
            }
        } else if (e.getActionCommand().equals("exit")) {
            System.exit(0);
        } else if (e.getActionCommand().equals("cut")) {
            textPane.cut();//
        } else if (e.getActionCommand().equals("copy")) {
            textPane.copy();//
        } else if (e.getActionCommand().equals("paste")) {
            textPane.paste();//
        } else if (e.getActionCommand().equals("about")) {
            JOptionPane.showMessageDialog(Notepad.this, "Michael Zhang 21015027");
        }
    }

}