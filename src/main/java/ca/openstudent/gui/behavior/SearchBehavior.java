package ca.openstudent.gui.behavior;

import javax.faces.component.behavior.ClientBehaviorBase;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.FacesBehavior;

@FacesBehavior("behavior.Search")
public class SearchBehavior extends ClientBehaviorBase {
	
	public String getScript(ClientBehaviorContext behaviorContext) {
		
		return "return confirm('Are you sure?')";
	}

}
