package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.CandidatoController;
import controller.QuestaoController;
import controller.QuestionarioController;
import controller.ResponderQuestionarioController;
import model.CandidatoModel;
import model.QuestaoModel;
import model.QuestionarioModel;
import model.ResponderQuestionarioModel;

public class FrmMenuPrincipal extends JFrame implements ActionListener {
	
    private JMenuItem cadastrarQuestionario = new JMenuItem("Questionario");
    private JMenuItem cadastrarQuestoes= new JMenuItem("Questoes");
    private JMenuItem cadastrarCandidatos = new JMenuItem("Candidato");
    private JMenuBar menuBar = new JMenuBar();
    private JMenu sair = new JMenu("Sair");
    private JMenu cadastrar = new JMenu("Cadastrar");
    private JMenuItem responder = new JMenuItem("Responder");
    private JDesktopPane desktop;
    
    FrmCadastrarQuestionarios frmQuestionarios= new FrmCadastrarQuestionarios();
    FrmCadastrarQuestoes frmQuestoes = new FrmCadastrarQuestoes();
    FrmCadastrarCandidatos frmCandidatos = new FrmCadastrarCandidatos();
    FrmResponderQuestionario frmResponderQuestionario = new FrmResponderQuestionario();
    
    public FrmMenuPrincipal() {
    	super();
    	
        Container conteudo = getContentPane();
        conteudo.setLayout(null);
        

         menuBar = new JMenuBar();//cria a barra de menu
        setJMenuBar(menuBar);//posiciona a barra de menu no alto da tela
        
        
        cadastrar.add(cadastrarQuestionario);
        cadastrar.add(cadastrarQuestoes);
        cadastrar.add(cadastrarCandidatos);
        cadastrar.add(responder);
        
        
        menuBar.add(cadastrar);//adiciona o menu Cadastros na barra de Menus
      //  menuBar.add(responder);//adiciona o menu Cadastros na barra de Menus
        
        cadastrarQuestionario.addActionListener(this);
        cadastrarQuestoes.addActionListener(this);
        cadastrarCandidatos.addActionListener(this);
        responder.addActionListener(this);

        
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //setBounds(inset, inset,
        //          screenSize.width  - inset*2,
        //          screenSize.height - inset*2);

        desktop = new JDesktopPane(); 
        setContentPane(desktop);
        desktop.setBackground(Color.BLACK);
        
        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

        setSize(screenSize.width,screenSize.height);
        setVisible(true);
        
        desktop.add(frmQuestionarios);
    	desktop.add(frmQuestoes);
    	desktop.add(frmCandidatos);
    	desktop.add(frmResponderQuestionario);
    	
    	frmQuestionarios.setVisible(false);
    	frmQuestoes.setVisible(false);
    	frmCandidatos.setVisible(false);
    	frmResponderQuestionario.setVisible(false);
        
        
    	
    }
    
    public void actionPerformed(ActionEvent evt){
  		Object src = evt.getSource();
  		if(src==cadastrarQuestionario){
  			createFrame(1);
  		}
  		if(src==cadastrarQuestoes){
  			createFrame(2);
  		}
  		if(src==cadastrarCandidatos){
  			createFrame(3);
  		}
  		if(src==responder){
  			createFrame(4);
  		}
     		if (src==sair){
          	System.exit(0);
          }
     }
    
    protected void createFrame(int opcao){
    	Dimension desktopSize;
    	Dimension jInternalFrameSize;
    	switch(opcao){
    		
    		case 1: 
 
        			frmQuestionarios.setVisible(true); 
        			frmQuestoes.setVisible(false);
        			frmCandidatos.setVisible(false);
        			frmResponderQuestionario.setVisible(false);
        			
        			QuestionarioModel questionarioModel = new QuestionarioModel();
        			QuestionarioController questionarioController = new QuestionarioController(frmQuestionarios, questionarioModel);
        			
        			desktopSize = desktop.getSize();
        			jInternalFrameSize = frmQuestionarios.getSize();
        			frmQuestionarios.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        			    (desktopSize.height- jInternalFrameSize.height)/2-100);
        			try {
            			frmQuestionarios.setSelected(true);
        			}catch(java.beans.PropertyVetoException e) {}
        			break;
        	
        	case 2: 
        			
					frmQuestoes.setVisible(true); 
					frmQuestionarios.setVisible(false); 
					frmCandidatos.setVisible(false); 
					frmResponderQuestionario.setVisible(false);
					
					QuestaoModel questaoModel = new QuestaoModel();
        			QuestaoController questaoController = new QuestaoController(frmQuestoes, questaoModel);
				
					desktopSize = desktop.getSize();
					jInternalFrameSize = frmQuestoes.getSize();
					frmQuestoes.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
							(desktopSize.height- jInternalFrameSize.height)/2-100);
					try {
						frmQuestoes.setSelected(true);
					}catch(java.beans.PropertyVetoException e) {}
					break;
					
        	case 3: 
        			
					frmCandidatos.setVisible(true); 
					frmQuestionarios.setVisible(false); 
        			frmQuestoes.setVisible(false);
        			frmResponderQuestionario.setVisible(false);
        			
        			CandidatoModel candidatoModel = new CandidatoModel();
        			CandidatoController candidatoController = new CandidatoController(frmCandidatos, candidatoModel);
					
					desktopSize = desktop.getSize();
					jInternalFrameSize = frmCandidatos.getSize();
					frmCandidatos.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
							(desktopSize.height- jInternalFrameSize.height)/2-100);
					try {
						frmCandidatos.setSelected(true);
					}catch(java.beans.PropertyVetoException e) {}
					break;	
					
          	case 4: 
    			
				frmCandidatos.setVisible(false); 
				frmQuestionarios.setVisible(false); 
    			frmQuestoes.setVisible(false);
    			frmResponderQuestionario.setVisible(true);
    			
    			ResponderQuestionarioModel responderQuestionarioModel = new ResponderQuestionarioModel();
    			CandidatoModel candidatoModel1 = new CandidatoModel();
    			ResponderQuestionarioController responderQuestionarioController = new ResponderQuestionarioController(frmResponderQuestionario, responderQuestionarioModel, candidatoModel1);
				
				desktopSize = desktop.getSize();
				jInternalFrameSize = frmResponderQuestionario.getSize();
				frmResponderQuestionario.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
						(desktopSize.height- jInternalFrameSize.height)/2-100);
				try {
					frmResponderQuestionario.setSelected(true);
				}catch(java.beans.PropertyVetoException e) {}
				break;	
    	}     	
    }
    


}
