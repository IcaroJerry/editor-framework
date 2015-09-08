/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.framework.menuoptionvideo.windowOption.commandchange;

import editor.framework.documentvideo.interfaces.ICommand;
import editor.framework.documentvideo.interfaces.IFrameController;
import editor.framework.documentvideo.products.VideoDocument;
import editor.framework.interfaces.ICore;
import editor.framework.menuoptionvideo.windowOption.algorithms.ModeFrameMedium;

/**
 *
 * @author ICAROJ
 */
public class ChangeFrameControllerMedium implements ICommand{

    public ChangeFrameControllerMedium(){
       currentDocument = (VideoDocument) ICore.getInstance().getProjectController().getCurrentDoucment();
    }
    
    @Override
    public void execute() {
       lastController = currentDocument.getFrameController();
       currentDocument.setFrameController(new ModeFrameMedium(currentDocument));
       System.out.println("user changed frame controller for Medium!");
    }

    @Override
    public void undo() {
        this.currentDocument.setFrameController(lastController);
        lastController = null;
         System.out.println("user undid change of controller!");
    }
    
    private final VideoDocument currentDocument;
    private IFrameController lastController;
}
