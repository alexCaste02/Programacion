package ejs.e_7;

import com.sun.management.OperatingSystemMXBean;

import javax.swing.*;
import java.awt.*;
import java.lang.management.ManagementFactory;


public class MonitorSistema extends JFrame{

    private JPanel mainPanel;
    private JPanel topHalf;
    private JPanel botHalf;
    private JProgressBar cpuBar;
    private JProgressBar ramBar;
    private JLabel cpuLabel;
    private JLabel ramLabel;
    private JButton actualizarButton;
    private JLabel cpuValueL;
    private JLabel ramValueL;
    private JButton autoTODOButton;
    private JSlider refreshSlider;
    private JLabel refreshLabel;

    public static void main(String[] args) {
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());} catch(Exception ignored){}
        EventQueue.invokeLater(MonitorSistema::start);
    }

    static void start(){
        MonitorSistema win = new MonitorSistema("Monitor del sistema - Alex.C.D");
    }

    public MonitorSistema(String titulo) throws HeadlessException {
        super(titulo);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setContentPane(mainPanel);
        pack();

        actualizarButton.addActionListener(e -> {
            // 2 OpSysMXBean(s) diferentes?? -- Uno extends otro???
            OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

            double cpuV = osBean.getCpuLoad()*100;
            double usedRam = osBean.getTotalMemorySize()-osBean.getFreeMemorySize();
            double ramV = (usedRam/osBean.getTotalMemorySize())*100;

            cpuBar.setValue((int) cpuV);
            cpuValueL.setText(String.format("%.2f",cpuV));

            ramBar.setValue((int) ramV);
            ramValueL.setText(String.format("%.2f",ramV));
        });

    }
}
