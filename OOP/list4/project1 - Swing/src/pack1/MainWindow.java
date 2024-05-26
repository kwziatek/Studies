package pack1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainWindow {
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JButton button;
    private JTextField textField;

    public MainWindow(){
        initalize();
    }
    private void initalize(){
        frame = new JFrame();
        frame.setLayout(new BorderLayout(10,5));
        frame.setTitle("Hello World");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800,500);
        frame.setLocationRelativeTo(null);
        //frame.setResizable(false);

        panel=new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(panel,BorderLayout.NORTH);

        textField = createJTextField();
        panel.add(textField);


        JPanel cenpanel=new JPanel();
        frame.add(cenpanel,BorderLayout.CENTER);
        label=new JLabel();
        cenpanel.add(label);



        button=new JButton("Clic");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String s=textField.getText();
                //label.setText(s);
                try{
                    int n=Integer.parseInt(s);
                    if(n>30){
                        label.setText("Podaj liczbe mniejsza lub rowna 30");
                        return;
                    }
                    else if(n<0){
                        throw new IllegalAccessException("Podaj liczbe nieujemna");
                    }
                    String text=new String();
                    for(int i=0; i<=n; i++){
                        WierszTrojkataPascala wierszTrojkataPascala=new WierszTrojkataPascala(i);
                        for(int j=0; j<=i; j++){
                            text+=" "+wierszTrojkataPascala.method2(j);
                        }
                        text+="<br>";
                    }


                    //label.setText("<html><center>Tekst<br>wieloliniowy<br>do wyśrodkowania</center></html>");
                    label.setText("<html><center>"+text+"</center></html>");
                    label.setHorizontalAlignment(SwingConstants.CENTER); // Ustawienie wyśrodkowania poziomego
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    panel.setSize(label.getPreferredSize());
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                }
                catch(NumberFormatException e1){
                    label.setText("Niepoprawna dana, podaj liczbę");
                }
                catch (Exception e2){
                    label.setText(e2.getMessage());
                }

            }
        });
        panel.add(button);

        

        frame.setVisible(true);
    }
    public JTextField createJTextField(){
        JTextField textfield=new JTextField(15);
        textfield.setFont(new Font("Arial",Font.BOLD,24));
        textfield.setForeground(Color.BLUE);
        textfield.setBackground(Color.YELLOW);
        textfield.setToolTipText("Podaj liczbę naturalna - numer ostatniego wiersza");
        //textfield.setMargin(new Insets(5,10,5,10));


        return textfield;
    }

}