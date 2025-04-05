/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author root
 */
public class MyListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent pe) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    if(pe.getPhaseId() == PhaseId.RESTORE_VIEW)      
    {
     System.out.println(" After Restore View");
    }
    if(pe.getPhaseId() == PhaseId.APPLY_REQUEST_VALUES)      
    {
     System.out.println(" After Apply request values");
    }
         if(pe.getPhaseId() == PhaseId.PROCESS_VALIDATIONS)      
    {
     System.out.println("Process Validation");
     
    }
          if(pe.getPhaseId() == PhaseId.UPDATE_MODEL_VALUES)      
    {
     System.out.println(" After update model values");
    }
           if(pe.getPhaseId() == PhaseId.RENDER_RESPONSE)      
    {
     System.out.println(" After Apply request values");
    }
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     if(pe.getPhaseId() == PhaseId.RESTORE_VIEW)      
    {
     System.out.println(" Before Restore View");
    }
    if(pe.getPhaseId() == PhaseId.APPLY_REQUEST_VALUES)      
    {
     System.out.println(" Before Apply request values");
    }
         if(pe.getPhaseId() == PhaseId.PROCESS_VALIDATIONS)      
    {
     System.out.println("Before Process Validation");
     
    }
          if(pe.getPhaseId() == PhaseId.UPDATE_MODEL_VALUES)      
    {
     System.out.println(" Before update model values");
    }
           if(pe.getPhaseId() == PhaseId.RENDER_RESPONSE)      
    {
     System.out.println(" before Apply request values");
    }
    }

    @Override
    public PhaseId getPhaseId() {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return PhaseId.ANY_PHASE;
    }
    
    
    
}
