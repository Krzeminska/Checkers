
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public final class GUI extends javax.swing.JFrame {
    
    MP Plansza = new MP();
    java.util.List<Ruchy> r = new ArrayList<>();
    
    Gra stan = new Gra();
    int[] Ruch = new int[4];
    int[] Odp = new int[4];
    
    
    public GUI() {
        initComponents();
        
        Plansza.setSize(p.getWidth()-1,p.getHeight()-1);
        p.add(Plansza);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p = new javax.swing.JPanel();
        text = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        p.setBackground(new java.awt.Color(0, 150, 0));
        p.setMinimumSize(new java.awt.Dimension(164, 164));
        p.setPreferredSize(new java.awt.Dimension(164, 164));
        p.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pMouseReleased(evt);
            }
        });

        text.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        text.setText(" ");

        javax.swing.GroupLayout pLayout = new javax.swing.GroupLayout(p);
        p.setLayout(pLayout);
        pLayout.setHorizontalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(text)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        pLayout.setVerticalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(text)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMousePressed
        int col = (evt.getX() - 2) / 20;
        int row = (evt.getY() - 2) / 20;
        
        if(stan.active)
            if(col >= 0 && col < 8 && row >=0 && row < 8) {
                Ruch[0] = row;
                Ruch[1] = col;
            } 
    }//GEN-LAST:event_pMousePressed

    private void pMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMouseReleased
        int col = (evt.getX() - 2) / 20;
        int row = (evt.getY() - 2) / 20;
        
        if(stan.active)
            if(col >= 0 && col < 8 && row >=0 && row < 8) {
                Ruch[2] = row;
                Ruch[3] = col;
                WykonajRuch();
            }    
    }//GEN-LAST:event_pMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

private void WykonajRuch() {
       // System.out.print("Ruch " + Ruch[0] + " " + Ruch[1] + ", " + Ruch[2] + " " + Ruch[3] + ";");
        if(Ruch[0]%2 != Ruch[1]%2)
            if(stan.plansza[Ruch[0]][Ruch[1]] != 0 && Ruch[2]<8 && Ruch[3]>=0 && Ruch[3]<8) {
                if(stan.LegalnyRuch()) {
                    stan.setPionekAt(Ruch[0], Ruch[1], Ruch[2], Ruch[3]);
                    if(stan.NajlepszaOdp()) {
                        //System.out.print("komputer odp: " + Odp[0] + " " + Odp[1] + ", " + Odp[2] + " " + Odp[3] + "; \n");
                        stan.setPionekAt(Odp[0], Odp[1], Odp[2], Odp[3]);
                    }
                    //Komputer nie ma ruchu
                    else if(!stan.NajlepszaOdp())
                    {
                        text.setForeground(Color.CYAN);
                        text.setText("Red/White : " + stan.pCount('r') + "/"+ stan.pCount('w'));
                        stan.active = false;
                    }
                    //błąd gry
                    else
                    {
                        text.setForeground(Color.RED);
                        text.setText("Error.");
                        stan.active = false;
                    }
                      
                }
            }
            
        Plansza.update();
    }

class MP extends JPanel
{
    @Override
    public void paintComponent(Graphics g)
    {
        //obramowanie:
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getSize().width-1, getSize().height-1);
        g.drawRect(1, 1, getSize().width-3, getSize().height-3);
        
        //kwadraciki szachownicy:
        for(int row = 0; row <8; row++) {
            for(int col = 0; col <8; col++) {
                if(row%2 == col%2) {
                     g.setColor(Color.LIGHT_GRAY);
                     g.fillRect(2 + col*20, 2 + row*20, 20, 20);
                }  
                else {
                    g.setColor(Color.gray);
                    g.fillRect(2 + col*20, 2 + row*20, 20, 20);
                    if(stan.PionekAt(row, col) != 0 && stan.PionekAt(row, col) < 13) {
                        g.setColor(Color.white);
                        g.fillOval(4 + col*20, 4 + row*20, 16, 16);
                    }
                    if(stan.PionekAt(row, col) != 0 && stan.PionekAt(row, col) >= 13) {
                        g.setColor(Color.red);
                        g.fillOval(4 + col*20, 4 + row*20, 16, 16);
                    }
                } 
                
            }
        }
    }
    public void update() {
                    //jezeli nie ma juz bialych pionkow
                    if(stan.pCount('w') == 0)
                    {
                        text.setForeground(Color.GREEN);
                        text.setText("!!!Wygrana!!!");
                        stan.active = false;
                    }
                    //jezeli nie ma juz czerwonych pionkow
                    else if(stan.pCount('r') == 0)
                    {
                        text.setForeground(Color.RED);
                        text.setText("!Przegrana!");
                        stan.active = false;
                    }
                    //wygrana poprzez doprowadzenie wszystkich pionkow na skraj planszy
                    else if(stan.CzyMaRuch())
                    {
                        int[] pionek = new int[2];
                        int iterator=0;
                        for(int x=12; x>0; x--)
                        {
                            if(stan.pionekAt(x))
                            {
                                pionek = stan.PionekAt(x);
                                if(pionek[0]==7)
                                    iterator++;
                            }
                        }
                        text.setForeground(Color.GREEN);
                        text.setText("Red/White : " + stan.pCount('r') + "/"+ iterator);
                        stan.active = false;
                    }
        this.repaint();
        p.add(this);
        p.setVisible(true);
    } 
}

class Gra {

    private final int[][] plansza = new int[8][8];
    public boolean active;
    
    Gra(){
        int iterator = 1;
       for(int i=0;i<8;i++)
           for(int j=0;j<8;j++) {
               if(i%2 != j%2)
               if(i < 3 || i > 4){
                   plansza[i][j] = iterator;
                   iterator++;
               } 
               else
                   plansza[i][j] = 0;
           }
       active = true;
    }

    
    //czy i jaki jest pionek na pozycji (row,col)
    public int PionekAt(int row, int col) {
        return plansza[row][col];
    }
    //gdzie jest pionek (pion)
    public int[] PionekAt(int pion) {
        int[] x = new int[2];
        for(int i=0;i<8;i++)
           for(int j=0;j<8;j++)
               if(plansza[i][j] == pion) {
                   x[0] = i;
                   x[1] = j;
               }
        return x;
    }
    //czy pionek istnieje
    public boolean pionekAt(int pion) {
        for(int i=0;i<8;i++)
           for(int j=0;j<8;j++)
               if(plansza[i][j] == pion) {
                   return true;
               }
        return false;
    }
    //Usuń pionek:
    public boolean PionekRemove(int row, int col) {
        if(stan.PionekAt(row,col) != 0) {
            plansza[row][col] = 0;
            return true;
        }
        return false;
    }
    //przestaw pionek na pozycję (z, do)
    public void setPionekAt(int row, int col, int row2, int col2) {
        int pionek = this.PionekAt(row, col);
        if(row2%2 != col2%2)
          if(plansza[row2][col2] == 0) {
            plansza[row][col] = 0;
            plansza[row2][col2] = pionek;
        }
    }
    //czy pole jest 
    public boolean LegalnyRuch() {
        int roznicaWierszy = Ruch[2] - Ruch[0];
        int roznicaKolumn = Ruch[3] - Ruch[1];
        //można chodzić tylko do góry:
        if(roznicaWierszy == -1)
            return true;
        else if(roznicaWierszy == -2)
            if(roznicaKolumn == 2) {
                if(stan.PionekAt(Ruch[2]+1, Ruch[3]-1)< 13) {
                    return PionekRemove(Ruch[2]+1,Ruch[3]-1);
                }
            }
            else if(roznicaKolumn == -2) {
                if(stan.PionekAt(Ruch[2]+1, Ruch[3]+1)< 13) {
                    return PionekRemove(Ruch[2]+1,Ruch[3]+1);
                }
            }
        
        return false;
    }
    //czy gracz moze wykonac ruch
    public boolean CzyMaRuch() {
        //n - ilosc pionkow; i - ilosc pionkow, ktore nie moga sie ruszyc 
        int n = stan.pCount('r');
        int i = 0;
        int[] pionek = new int[2];
        //szukam pionka czerwonego...
        for(int x=13; x<25; x++)
        {
            //...jezeli istnieje...
            if(stan.pionekAt(x))
            {
                pionek = stan.PionekAt(x);
                //to sprawdzam, czy moze on zostac legalnie przestawiony
                if(pionek[0]==0)
                    i++;
                
            }
            
        }
        if(n == i)
            return true;
        return false;
    }
    
    
    public boolean NajlepszaOdp() {
        
        
        //odp - czy znalazlam legalne pole
        boolean odp = false;
        //
        int[] pionek = new int[2];
        int[] pionekToRemove = new int[2];
        for(int i=0; i<2; i++)
            pionek[i] = 0;
        
        r.clear();
        
        //szukam pionka:       
        for(int x=12; x>0; x--) {
            //jezeli pionek istnieje...
            if(stan.pionekAt(x))
            {
                pionek = stan.PionekAt(x);
                Odp[0] = pionek[0];
                Odp[1] = pionek[1];
                //spr, czy pionek nie jest na skraju planszy (jest bezpieczny i nie ma ruchów)
                if(Odp[0] == 7)
                    break;
                //jezeli pionek jest na lewej scianie
                else if(Odp[1] == 0)
                {
                    //... to sprawdzam, czy w jego otoczeniu jest legalne pole:
                    Odp[2] = pionek[0] +1;
                    Odp[3] = pionek[1] +1;
                    if(stan.PionekAt(Odp[2], Odp[3]) == 0)
                    {
                        if(Odp[2]+1<8 && Odp[3]+1<8 && Odp[3]-1>0)
                            if(stan.PionekAt(Odp[2]+1, Odp[3]+1) > 12 || stan.PionekAt(Odp[2]+1, Odp[3]-1) > 12)
                                r.add(new Ruchy(Odp,x,1));
                        else
                            r.add(new Ruchy(Odp,x,5));
                    }
                    else if(stan.PionekAt(Odp[2], Odp[3]) > 12 && Odp[3]+1<8) {
                        if(stan.PionekAt(Odp[2]+1, Odp[3]+1) == 0)
                        {
                                        pionekToRemove[0] = Odp[2];
                                        pionekToRemove[1] = Odp[3];
                                        if(Odp[2]+1<9 && Odp[3]+1<9)
                                        {
                                            Odp[2] = Odp[2]+1;
                                            Odp[3] = Odp[3]+1;
                                            r.add(new Ruchy(Odp,x,10,pionekToRemove));
                                        }
                        }
                    }
                }
                //jezeli pionek jest na prawej scianie
                else if(Odp[1] == 7)
                {
                    //... to sprawdzam, czy w jego otoczeniu jest legalne pole:
                    Odp[2] = pionek[0] +1;
                    Odp[3] = pionek[1] -1;
                    if(stan.PionekAt(Odp[2], Odp[3]) == 0)
                    {
                        if(Odp[2]+1<8 && Odp[3]+1<8 && Odp[3]-1>0)
                            if(stan.PionekAt(Odp[2]+1, Odp[3]+1) > 12 || stan.PionekAt(Odp[2]+1, Odp[3]-1) > 12)
                                r.add(new Ruchy(Odp,x,1));
                        else
                            r.add(new Ruchy(Odp,x,5));
                    }
                    else if(stan.PionekAt(Odp[2], Odp[3]) > 12 && Odp[3]-1>=0) {
                        if(stan.PionekAt(Odp[2]+1, Odp[3]-1) == 0)
                        {
                        pionekToRemove[0] = Odp[2];
                        pionekToRemove[1] = Odp[3];
                        if(Odp[2]+1<9 && Odp[3]-1<9)
                                        {
                                            Odp[2] = Odp[2]+1;
                                            Odp[3] = Odp[3]-1;
                                            r.add(new Ruchy(Odp,x,10,pionekToRemove));
                                        }
                        }
                    }
                }
                //jezeli pionek jest na srodku planszy
                else if(Odp[0]>=0 && Odp[0]<7 && Odp[1]>0 && Odp[1]<7)
                {
                    //... to sprawdzam, czy w jego otoczeniu jest legalne pole:
                    for(int i=0;i<2;i++) {
                        switch(i) {
                            case 0:
                                Odp[2] = pionek[0] +1;
                                Odp[3] = pionek[1] -1;
                                if(stan.PionekAt(Odp[2], Odp[3]) == 0)
                                {
                                    if(Odp[2]+1<8 && Odp[3]+1<8 && Odp[3]-1>0)
                                        if(stan.PionekAt(Odp[2]+1, Odp[3]+1) > 12 || stan.PionekAt(Odp[2]+1, Odp[3]-1) > 12)
                                            r.add(new Ruchy(Odp,x,1));
                                    else
                                        r.add(new Ruchy(Odp,x,5));
                                }
                                else if(stan.PionekAt(Odp[2], Odp[3]) > 12  && Odp[3]-1>=0) {
                                    if(stan.PionekAt(Odp[2]+1, Odp[3]-1) == 0)
                                    {
                                        pionekToRemove[0] = Odp[2];
                                        pionekToRemove[1] = Odp[3];
                                        if(Odp[2]+1<9 && Odp[3]-1<9)
                                        {
                                            Odp[2] = Odp[2]+1;
                                            Odp[3] = Odp[3]-1;
                                            r.add(new Ruchy(Odp,x,10,pionekToRemove));
                                        }
                                    }
                                }
                                break;
                            case 1:
                                Odp[2] = pionek[0] +1;
                                Odp[3] = pionek[1] +1;
                                if(stan.PionekAt(Odp[2], Odp[3]) == 0)
                                {
                                    if(Odp[2]+1<8 && Odp[3]+1<8 && Odp[3]-1>0)
                                        if(stan.PionekAt(Odp[2]+1, Odp[3]+1) > 12 || stan.PionekAt(Odp[2]+1, Odp[3]-1) > 12)
                                            r.add(new Ruchy(Odp,x,1));
                                    else
                                        r.add(new Ruchy(Odp,x,5));
                                }
                                 else if(stan.PionekAt(Odp[2], Odp[3]) > 12 && Odp[3]+1<8) {
                                    if(stan.PionekAt(Odp[2]+1, Odp[3]+1) == 0)
                                    {
                                        pionekToRemove[0] = Odp[2];
                                        pionekToRemove[1] = Odp[3];
                                        if(Odp[2]+1<9 && Odp[3]+1<9)
                                        {
                                            Odp[2] = Odp[2]+1;
                                            Odp[3] = Odp[3]+1;
                                            r.add(new Ruchy(Odp,x,10,pionekToRemove));
                                        }
                                    }
                                }
                                break;
                        }
                    }
                }
            }
        }
        
        //jezeli lista mozliwych odpowiedzi komputera nie jest pusta...
        if(!r.isEmpty())
        {
            //...to znajdz ruch, który ma najwieksza wage
            int MAX = 0;
            for(int i=r.size()-1;i>=0;i--)
            {
                if(MAX < r.get(i).waga)
                {
                    MAX = r.get(i).waga;
                    Odp = r.get(i).Odp2;
                    //jezeli w znalezionym ruchu dochodzi do zbicia, to usun zbity pionek
                    if(r.get(i).pToRemove[0] != 0)
                    {
                        if(stan.PionekRemove(r.get(i).pToRemove[0], r.get(i).pToRemove[1]))
                            odp = true;
                    }
                    else
                        odp = true;
                    
                }
                r.get(i).print();
            }
        }
        return odp;
        
    }
    
    public int pCount(char s)
    {
        int n = 0;
        if(s == 'r')
        {
            for(int i=0;i<8;i++)
                for(int j=0;j<8;j++)
                    if(plansza[i][j] >= 13) {
                        n++;
                    }
        }
        else if(s == 'w')
        {
            for(int i=0;i<8;i++)
                for(int j=0;j<8;j++)
                    if(plansza[i][j] > 0 && plansza[i][j] < 13) {
                        n++;
                    }
        }
        return n;
    }
    
    
}

class Ruchy {
        int[] Odp2 = new int[4];
        int pioneczek, waga;
        int[] pToRemove = new int[2];
        
        Ruchy(int[] o, int p, int w, int[] x)
        {
            Odp2[0] = o[0];
            Odp2[1] = o[1];
            Odp2[2] = o[2];
            Odp2[3] = o[3];
            pioneczek = p;
            waga = w;
            pToRemove = x;
        }
        Ruchy(int[] o, int p, int w)
        {
            Odp2[0] = o[0];
            Odp2[1] = o[1];
            Odp2[2] = o[2];
            Odp2[3] = o[3];
            pioneczek = p;
            waga = w;
            pToRemove[0] = 0;
            pToRemove[1] = 0;
        }
        public void print() {
            System.out.print("Odp " + pioneczek + "("  + waga + "): " + Odp2[0] + " " + Odp2[1] + ", " + Odp2[2] + " " + Odp2[3] + "; \n");
        }
}


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel p;
    private javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables
}
