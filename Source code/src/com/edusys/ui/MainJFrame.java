/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.ui;

import com.edusys.utils.Auth;
import com.edusys.utils.MsgBox;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author balis
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form mainFrame
     */
    public MainJFrame() {
        FlatLightLaf.setup();
        initComponents();
        startClock();
        setTitle("EduSys");
        displayUserInfo();
        setLocationRelativeTo(null);
    }

    void startClock() {
        class TimeClock extends Thread {

            @Override
            public void run() {
                while (true) {
                    lblClock.setText(new SimpleDateFormat("hh:mm:ss a").format(Calendar.getInstance().getTime()));
                }
            }
        }
        TimeClock timeClock = new TimeClock();
        timeClock.start();
    }

    void displayUserInfo() {
        String userID = Auth.user.getMaNV();
        String role = Auth.user.isVaiTro() ? "Manager" : "Employee";
        lblUserInfo.setText("UserID: " + userID + " |  Role: " + role);
    }

    void openChangePassword() {
        if (Auth.isLogin()) {
            new ChangePasswordJDialog(this, rootPaneCheckingEnabled).setVisible(true);
        } else {
            MsgBox.alert(this, "Please login!");
        }
    }

    void LogOut() {
        Auth.clear();
        this.dispose();
        new LoginJDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }

    void Exit() {
        if (MsgBox.confirm(this, "Do you want to end this session?")) {
            System.exit(0);
        }
    }

    void openSubjects() {
        new SubjectJDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }

    void openCourses() {
        new CourseJDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }

    void openLearners() {
        new LearnerJDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }

    void openStudents() {
        new StudentJDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }

    void openEmployees() {
        new EmployeeJDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }

    void openGuide() {
        try {
            Desktop.getDesktop().browse(new URI("https://www.kansastag.gov/advhtml_doc_upload/caplio_500se_software_user_guide.pdf"));
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void openAboutUs() {
        new AboutJDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }

    void openStatistics(int index) {
        if (Auth.isLogin()) {
            if (index == 3 && !Auth.isManager()) {
                MsgBox.alert(this, "You're not authorized to view revenue tab!");
            } else {
                StatisticJDialog statisticJDialog = new StatisticJDialog(this, true);
                statisticJDialog.selectTab(index);
                statisticJDialog.setVisible(true);
            }
        } else {
            MsgBox.alert(this, "Please login!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator8 = new javax.swing.JSeparator();
        ToolBar = new javax.swing.JToolBar();
        btnLogout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnSubjects = new javax.swing.JButton();
        btnLearners = new javax.swing.JButton();
        btnCourses = new javax.swing.JButton();
        btnStudents = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnGuide = new javax.swing.JButton();
        pnlTrump = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlStatusBar = new javax.swing.JPanel();
        lblClock = new javax.swing.JLabel();
        lblUserInfo = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        mnuSystem = new javax.swing.JMenu();
        mniLogout = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        miniChangepass = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mniExit = new javax.swing.JMenuItem();
        mnuManaging = new javax.swing.JMenu();
        mniSubjects = new javax.swing.JMenuItem();
        mniCourses = new javax.swing.JMenuItem();
        mniLearners = new javax.swing.JMenuItem();
        mniStudents = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mniEmployees = new javax.swing.JMenuItem();
        mnuStatistics = new javax.swing.JMenu();
        mniScoreboard = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mniLearnerNumber = new javax.swing.JMenuItem();
        mniSubjectScore = new javax.swing.JMenuItem();
        mniRevenue = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        mniGuide = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        mniAboutUs = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ToolBar.setRollover(true);

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_logout_rounded_up_20px.png"))); // NOI18N
        btnLogout.setText("Log out");
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.setFocusable(false);
        btnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        ToolBar.add(btnLogout);

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_exit_20px.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setFocusable(false);
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        ToolBar.add(btnExit);
        ToolBar.add(jSeparator1);

        btnSubjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_book_20px.png"))); // NOI18N
        btnSubjects.setText("Subjects");
        btnSubjects.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubjects.setFocusable(false);
        btnSubjects.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSubjects.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubjectsActionPerformed(evt);
            }
        });
        ToolBar.add(btnSubjects);

        btnLearners.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_students_20px.png"))); // NOI18N
        btnLearners.setText("Learners");
        btnLearners.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLearners.setFocusable(false);
        btnLearners.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnLearners.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLearners.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLearnersActionPerformed(evt);
            }
        });
        ToolBar.add(btnLearners);

        btnCourses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_course_20px.png"))); // NOI18N
        btnCourses.setText("Courses");
        btnCourses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCourses.setFocusable(false);
        btnCourses.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCourses.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCoursesActionPerformed(evt);
            }
        });
        ToolBar.add(btnCourses);

        btnStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_student_male_20px.png"))); // NOI18N
        btnStudents.setText("Students");
        btnStudents.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStudents.setFocusable(false);
        btnStudents.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnStudents.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentsActionPerformed(evt);
            }
        });
        ToolBar.add(btnStudents);
        ToolBar.add(jSeparator2);

        btnGuide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_flag_2_20px.png"))); // NOI18N
        btnGuide.setText("Guide");
        btnGuide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuide.setFocusable(false);
        btnGuide.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGuide.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuideActionPerformed(evt);
            }
        });
        ToolBar.add(btnGuide);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_education_240px.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("JetBrains Mono Light", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("EDUSYS");

        javax.swing.GroupLayout pnlTrumpLayout = new javax.swing.GroupLayout(pnlTrump);
        pnlTrump.setLayout(pnlTrumpLayout);
        pnlTrumpLayout.setHorizontalGroup(
            pnlTrumpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTrumpLayout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addGroup(pnlTrumpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTrumpLayout.setVerticalGroup(
            pnlTrumpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTrumpLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        pnlStatusBar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblClock.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblClock.setForeground(new java.awt.Color(255, 51, 51));
        lblClock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_alarm_clock_25px.png"))); // NOI18N

        lblUserInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_username_25px.png"))); // NOI18N

        javax.swing.GroupLayout pnlStatusBarLayout = new javax.swing.GroupLayout(pnlStatusBar);
        pnlStatusBar.setLayout(pnlStatusBarLayout);
        pnlStatusBarLayout.setHorizontalGroup(
            pnlStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStatusBarLayout.createSequentialGroup()
                .addComponent(lblUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 525, Short.MAX_VALUE)
                .addComponent(lblClock, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlStatusBarLayout.setVerticalGroup(
            pnlStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblClock, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
            .addComponent(lblUserInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mnuSystem.setText("System");
        mnuSystem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mniLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_logout_rounded_up_20px.png"))); // NOI18N
        mniLogout.setText("Log out");
        mniLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLogoutActionPerformed(evt);
            }
        });
        mnuSystem.add(mniLogout);
        mnuSystem.add(jSeparator3);

        miniChangepass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_change_20px.png"))); // NOI18N
        miniChangepass.setText("Change Password");
        miniChangepass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miniChangepassActionPerformed(evt);
            }
        });
        mnuSystem.add(miniChangepass);
        mnuSystem.add(jSeparator4);

        mniExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        mniExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_exit_20px.png"))); // NOI18N
        mniExit.setText("Exit");
        mnuSystem.add(mniExit);

        MenuBar.add(mnuSystem);

        mnuManaging.setText("Managing");
        mnuManaging.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mniSubjects.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniSubjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_book_20px.png"))); // NOI18N
        mniSubjects.setText("Subjects");
        mniSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSubjectsActionPerformed(evt);
            }
        });
        mnuManaging.add(mniSubjects);

        mniCourses.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniCourses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_course_20px.png"))); // NOI18N
        mniCourses.setText("Courses");
        mniCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCoursesActionPerformed(evt);
            }
        });
        mnuManaging.add(mniCourses);

        mniLearners.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniLearners.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_students_20px.png"))); // NOI18N
        mniLearners.setText("Learners");
        mniLearners.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLearnersActionPerformed(evt);
            }
        });
        mnuManaging.add(mniLearners);

        mniStudents.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_student_male_20px.png"))); // NOI18N
        mniStudents.setText("Students");
        mniStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniStudentsActionPerformed(evt);
            }
        });
        mnuManaging.add(mniStudents);
        mnuManaging.add(jSeparator5);

        mniEmployees.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniEmployees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_employee_20px.png"))); // NOI18N
        mniEmployees.setText("Employee");
        mniEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEmployeesActionPerformed(evt);
            }
        });
        mnuManaging.add(mniEmployees);

        MenuBar.add(mnuManaging);

        mnuStatistics.setText("Statistics");
        mnuStatistics.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mniScoreboard.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        mniScoreboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_grades_20px.png"))); // NOI18N
        mniScoreboard.setText("Score Board");
        mniScoreboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniScoreboardActionPerformed(evt);
            }
        });
        mnuStatistics.add(mniScoreboard);
        mnuStatistics.add(jSeparator6);

        mniLearnerNumber.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        mniLearnerNumber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_report_card_20px.png"))); // NOI18N
        mniLearnerNumber.setText("Learners Number");
        mniLearnerNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLearnerNumberActionPerformed(evt);
            }
        });
        mnuStatistics.add(mniLearnerNumber);

        mniSubjectScore.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        mniSubjectScore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_book_20px_1.png"))); // NOI18N
        mniSubjectScore.setText("Subjects Score");
        mniSubjectScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSubjectScoreActionPerformed(evt);
            }
        });
        mnuStatistics.add(mniSubjectScore);

        mniRevenue.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        mniRevenue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_us_dollar_20px.png"))); // NOI18N
        mniRevenue.setText("Revenue");
        mniRevenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniRevenueActionPerformed(evt);
            }
        });
        mnuStatistics.add(mniRevenue);

        MenuBar.add(mnuStatistics);

        mnuHelp.setText("Help");
        mnuHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mniGuide.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mniGuide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_flag_2_20px.png"))); // NOI18N
        mniGuide.setText("Guide");
        mniGuide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGuideActionPerformed(evt);
            }
        });
        mnuHelp.add(mniGuide);
        mnuHelp.add(jSeparator7);

        mniAboutUs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/icons8_help_20px.png"))); // NOI18N
        mniAboutUs.setText("About us");
        mniAboutUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAboutUsActionPerformed(evt);
            }
        });
        mnuHelp.add(mniAboutUs);

        MenuBar.add(mnuHelp);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlTrump, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlStatusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlTrump, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnlStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSubjectsActionPerformed
        openSubjects();
    }//GEN-LAST:event_mniSubjectsActionPerformed

    private void mniAboutUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAboutUsActionPerformed
        openAboutUs();
    }//GEN-LAST:event_mniAboutUsActionPerformed

    private void mniEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEmployeesActionPerformed
        openEmployees();
    }//GEN-LAST:event_mniEmployeesActionPerformed

    private void btnStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentsActionPerformed
        openStudents();
    }//GEN-LAST:event_btnStudentsActionPerformed

    private void btnCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoursesActionPerformed
        openCourses();
    }//GEN-LAST:event_btnCoursesActionPerformed

    private void mniCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCoursesActionPerformed
        openCourses();
    }//GEN-LAST:event_mniCoursesActionPerformed

    private void mniStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniStudentsActionPerformed
        openStudents();
    }//GEN-LAST:event_mniStudentsActionPerformed

    private void btnSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubjectsActionPerformed
        openSubjects();
    }//GEN-LAST:event_btnSubjectsActionPerformed

    private void btnLearnersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLearnersActionPerformed
        openLearners();
    }//GEN-LAST:event_btnLearnersActionPerformed

    private void mniLearnersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLearnersActionPerformed
        openLearners();
    }//GEN-LAST:event_mniLearnersActionPerformed

    private void miniChangepassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miniChangepassActionPerformed
        openChangePassword();
    }//GEN-LAST:event_miniChangepassActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        Exit();
    }//GEN-LAST:event_btnExitActionPerformed

    private void mniScoreboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniScoreboardActionPerformed
        openStatistics(0);
    }//GEN-LAST:event_mniScoreboardActionPerformed

    private void mniLearnerNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLearnerNumberActionPerformed
        openStatistics(1);
    }//GEN-LAST:event_mniLearnerNumberActionPerformed

    private void mniSubjectScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSubjectScoreActionPerformed
        openStatistics(2);
    }//GEN-LAST:event_mniSubjectScoreActionPerformed

    private void mniRevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRevenueActionPerformed
        openStatistics(3);
    }//GEN-LAST:event_mniRevenueActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        LogOut();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void mniLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLogoutActionPerformed
        LogOut();
    }//GEN-LAST:event_mniLogoutActionPerformed

    private void btnGuideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuideActionPerformed
        openGuide();
    }//GEN-LAST:event_btnGuideActionPerformed

    private void mniGuideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniGuideActionPerformed
        openGuide();
    }//GEN-LAST:event_mniGuideActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JToolBar ToolBar;
    private javax.swing.JButton btnCourses;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGuide;
    private javax.swing.JButton btnLearners;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnStudents;
    private javax.swing.JButton btnSubjects;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblUserInfo;
    private javax.swing.JMenuItem miniChangepass;
    private javax.swing.JMenuItem mniAboutUs;
    private javax.swing.JMenuItem mniCourses;
    private javax.swing.JMenuItem mniEmployees;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniGuide;
    private javax.swing.JMenuItem mniLearnerNumber;
    private javax.swing.JMenuItem mniLearners;
    private javax.swing.JMenuItem mniLogout;
    private javax.swing.JMenuItem mniRevenue;
    private javax.swing.JMenuItem mniScoreboard;
    private javax.swing.JMenuItem mniStudents;
    private javax.swing.JMenuItem mniSubjectScore;
    private javax.swing.JMenuItem mniSubjects;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenu mnuManaging;
    private javax.swing.JMenu mnuStatistics;
    private javax.swing.JMenu mnuSystem;
    private javax.swing.JPanel pnlStatusBar;
    private javax.swing.JPanel pnlTrump;
    // End of variables declaration//GEN-END:variables
}
