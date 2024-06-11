import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;
public class VotingMachine extends JFrame{
    final static String url = "jdbc:mysql://localhost/voting_machine";
    final static String usr = "root";
    final static String pass = "7152118122";
    private JPanel vote;
    private JButton selectButton,selectButton1,selectButton2,selectButton3,selectButton4,selectButton5,selectButton6,selectButton7,selectButton8,selectButton9,selectButton10;
    static String party,n,v,a,p;
    public void votelist(){

        try{
            String voter_id = v;
            String name = n;
            String age = a;
            String phn = p;
            String choose_party = party;
            Connection con = DriverManager.getConnection(url,usr,pass);
            String s = "INSERT INTO voter_detail(voter_id,name,age,phn,choose_party) VALUES (?,?,?,?,?)";
            PreparedStatement pstt =con.prepareStatement(s);
            pstt.setString(1,voter_id);
            pstt.setString(2,name);
            pstt.setString(3,age);
            pstt.setString(4,phn);
            pstt.setString(5,choose_party);
            pstt.executeUpdate();
            JOptionPane.showMessageDialog(null,"you are select "+"'"+party+"'");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"APPLICATION  PROBLEM");
            e.getMessage();
        }
    }
    public void votingdetail(){
        Random random = new Random();
        int num[] = new int[3];
        char str[] = new char[3];
        char alpha[] = new char[3];
        char alph[] = new char[3];
        for(int i=0;i<3;i++) {
            num[i] = random.nextInt(10);
            str[i] = Integer.toString(num[i]).charAt(0);
            alpha[i] = (char) ('A' + random.nextInt(26));
            alph[i] = (char) ('a' + random.nextInt(26));
        }
        String captcha = str[2]+""+alpha[1]+""+str[0]+""+str[1]+""+alph[0]+""+ alpha[2];

        setLayout(new java.awt.FlowLayout(FlowLayout.LEFT));
        JPanel panel = new JPanel();
        Font customfont = new Font("Bold",Font.PLAIN,16);
        JLabel nme = new JLabel("Eter your name      :");
        nme.setFont(customfont);
        JTextField nmer = new JTextField(15);
        JLabel ag = new JLabel("Eter your age           :");
        ag.setFont(customfont);
        JTextField ager = new JTextField(10);
        JLabel phn = new JLabel(" Eter your mobile no.    :");
        phn.setFont(customfont);
        JTextField phnr = new JTextField(10);
        JLabel vd = new JLabel(" Eter your voter id no.  :");
        vd.setFont(customfont);
        JTextField vidr = new JTextField(12);
        JLabel capr = new JLabel(" Enter captcha");
        capr.setFont(customfont);
        JLabel cap = new JLabel("       "+captcha);
        cap.setFont(customfont);
        JTextField val = new JTextField(10);
        JLabel label = new JLabel("                                                                                                                          ");
        JButton btn = new JButton("submit");
        btn.setFont(customfont);
        JButton can = new JButton("cancel");
        can.setFont(customfont);

        setContentPane(panel);
        getContentPane().add(nme,BorderLayout.CENTER);
        add(nmer);
        getContentPane().add(ag,BorderLayout.CENTER);
        add(ager);
        getContentPane().add(phn,BorderLayout.CENTER);
        add(phnr);
        getContentPane().add(vd,BorderLayout.CENTER);
        add(vidr);
        getContentPane().add(capr,BorderLayout.CENTER);
        getContentPane().add(cap,BorderLayout.CENTER);
        add(val);
        add(label);
        getContentPane().add(btn,BorderLayout.CENTER);
        getContentPane().add(can,BorderLayout.CENTER);
        setTitle("DETAIL");
        setSize(350, 380);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String name = nmer.getText();
                String vid = vidr.getText();
                String age = ager.getText();
                String phone = phnr.getText();
                String value = val.getText();

                if (name.isEmpty() || age.isEmpty() || phone.isEmpty() || vid.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"ALL VALUE REQUIRED");
                    votingdetail();
                }
                else if(vid.length()!=10||phone.length()!=10){
                    JOptionPane.showMessageDialog(null,"INVALID ENTRY");
                    votingdetail();
                }
                else if(value.compareTo(captcha)!=0){
                    JOptionPane.showMessageDialog(null,"ENTER VALID CAPTCHA");
                    votingdetail();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Thanks for your detail");
                    votingselect();
                    n=name.toLowerCase();
                    v=vid.toUpperCase();
                    a=age;
                    p=phone;
                }
            }
        });

        can.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    public void votingselect(){
        setContentPane(vote);
        setTitle("Voting Machine");
        setSize(600, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                party = "NATIONAL CONGRESS";
                votelist();

            }
        });

        selectButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                party = "BHARTIYA JANATA PARTY";
                votelist();
            }
        });
        selectButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                party = "AAM ADMI PARTY";
                votelist();
            }
        });
        selectButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                party = "BHAHUJAN SAMAJ PARTY";
                votelist();
            }
        });
        selectButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                party = "RASTRIYA JANTA  PARTY";
                votelist();
            }
        });
        selectButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                party = "NATIONALIST CONGRESS PARTY";
                votelist();
            }
        });
        selectButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                party = "COMMUNIST PARTY OF INDIA";
                votelist();
            }
        });
        selectButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                party = "SIJU JANTA DAL";
                votelist();
            }
        });
        selectButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                party = "SHIV SENA";
                votelist();
            }
        });
        selectButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                party = "SAMAJWADI PARTY";
                votelist();
            }
        });
        selectButton10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                party = "NOTA";
                votelist();
            }
        });
    }

    public void admin(){
        setLayout(new java.awt.FlowLayout(FlowLayout.LEFT));
        JPanel pan = new JPanel();
        Font customfont = new Font("Bold",Font.PLAIN,16);
        JLabel id = new JLabel("    ****YOUR IDENTITY****         ");
        id.setFont(customfont);
        JLabel label = new JLabel("                                                                                                                          ");
        JButton voter = new JButton("VOTER");
        voter.setFont(customfont);
        JButton admin = new JButton("ADMIN");
        admin.setFont(customfont);
        JLabel label1 = new JLabel("                                                                                                                          ");
        JButton can = new JButton("cancel");

        setContentPane(pan);
        getContentPane().add(id,BorderLayout.CENTER);
        add(label);
        getContentPane().add(voter,BorderLayout.CENTER);
        getContentPane().add(admin,BorderLayout.CENTER);
        add(label1);
        getContentPane().add(can,BorderLayout.CENTER);

        setTitle("VOTING IDENTITY");
        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);

        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                setVisible(false);
                adpass();

            }
        });
        voter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                setVisible(false);
                SwingUtilities.invokeLater(()->{
                    votingdetail();
                });
            }
        });

        can.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    public void showwin(){
        try{
            Connection con = DriverManager.getConnection(url,usr,pass);
            String win = "select choose_party from win_vote where vote_no = (select max(vote_no) from win_vote ); ";
            PreparedStatement pst = con.prepareStatement(win);
            ResultSet rst = pst.executeQuery();
            rst.next();
            String winning_party = rst.getString("choose_party");

            setLayout(new java.awt.FlowLayout(FlowLayout.LEFT));
            JPanel pan = new JPanel();
            Font customfont = new Font("Bold",Font.PLAIN,18);
            JLabel lab1 = new JLabel("                                                            ");
            JLabel lab = new JLabel("    ****WINNING PARTY IS****         ");
            lab.setFont(customfont);
            JLabel wn = new JLabel("::   "+winning_party);
            wn.setFont(customfont);
            wn.setForeground(Color.BLUE);
            JButton ok = new JButton("   OK   ");
            ok.setFont(customfont);
            pst.close();
            rst.close();

            setContentPane(pan);
            add(lab1);
            getContentPane().add(lab,BorderLayout.CENTER);
            getContentPane().add(wn,BorderLayout.CENTER);

            String winlist = "select choose_party, vote_no from win_vote order by vote_no desc;";
            PreparedStatement pstt = con.prepareStatement(winlist);
            ResultSet rstt = pstt.executeQuery();
            JLabel lab2 = new JLabel("   PARTY VOTE LIST                                                         ");
            lab2.setFont(customfont);
            getContentPane().add(lab2,BorderLayout.CENTER);;
            while(rstt.next()){
                String parti = rstt.getString("choose_party");
                int vote = rstt.getInt("vote_no");
                JLabel c1 = new JLabel(":: "+parti);
                JLabel c2 = new JLabel(":: "+vote+"    ");
                c1.setFont(customfont);
                c2.setFont(customfont);
                c1.setForeground(Color.MAGENTA);
                c2.setForeground(Color.GREEN);
                getContentPane().add(c1);
                getContentPane().add(c2);
            }
            JLabel lab3 = new JLabel("                                                                                                      ");
            add(lab3);
            add(ok);

            setTitle("WINNING PARTY LIST");
            setSize(500, 500);
            setVisible(true);
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setLocationRelativeTo(null);


            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    System.exit(0);
                }
            });

        }catch (Exception e){e.printStackTrace();}

    }
    public void adpass(){

        String str = "7152118122";
        setLayout(new java.awt.FlowLayout(FlowLayout.LEFT));
        JPanel pane = new JPanel();
        Font customfont = new Font("Bold",Font.PLAIN,20);
        JLabel pas = new JLabel("Enter Admin Password");
        pas.setFont(customfont);
        JPasswordField pass = new JPasswordField(20);
        JButton btn = new JButton("check");
        btn.setFont(customfont);
        setContentPane(pane);
        add(pas);
        add(pass);
        add(btn);
        setTitle("ADMIN LOGIN");
        setSize(350, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] passwd = pass.getPassword();
                String paswd = new String(passwd);
                dispose();
                if (str.compareTo(paswd) == 0) {
                    JOptionPane.showMessageDialog(null, " PASSWORD ENABLE");
                    showwin();
                } else {
                    JOptionPane.showMessageDialog(null, "PASSWORD DISABLE");
                    adpass();

                }
            }
        });
    }
    public static void main(String[] args){
        VotingMachine v = new VotingMachine();
        SwingUtilities.invokeLater(()-> {
            v.admin();
        });
    }
}