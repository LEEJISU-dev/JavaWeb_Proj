package com.team.controller;

import com.team.controller.action.*;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		super();
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory :" + command);
		
		if(command.equals("Main")) {
			action = new MainAction();
		}
		else if(command.equals("Join")) {
			action = new JoinAction();
		}
		else if(command.equals("DoJoin")) {
			action = new DoJoinAction();
		}
		else if(command.equals("Login")) {
			action = new LoginAction();
		}
		else if(command.equals("Logout")) {
			action = new LogoutAction();
		}
		else if(command.equals("PAdd")) {
			action = new PAddAction();
		}
		else if(command.equals("DoPAdd")) {
			action = new DoPAddAction();
		}
		else if(command.equals("MInfo")) {
			action = new MInfoAction();
		}
	    else if(command.equals("PSList")) {
	        action = new PSListAction();
	    }
	    else if(command.equals("CPW")) {
	        action = new CPWAction();
	    }
	    else if(command.equals("DoCPW")) {
	        action = new DoCPWAction();
	    }
	    else if(command.equals("UIDelete")) {
	        action = new UIDeleteAction();
	    }
	    else if(command.equals("UIModify")) {
	        action = new UIModifyAction();
	    }
	    else if (command.equals("PList")) {
	         action = new PListAction();
	    }
	    else if (command.equals("PView")) {
	         action = new PViewAction();
	    }
	    else if (command.equals("PDelete")) {
	         action = new PDeleteAction();
	    }
	    else if (command.equals("DoPDelete")) {
	         action = new DoPDeleteAction();
	    }
	    else if (command.equals("PModify")) {
	         action = new PModifyAction();
	    }
	    else if (command.equals("DoPModify")) {
	         action = new DoPModifyAction();
	    }
	    else if (command.equals("PBList")) {
	         action = new PBListAction();
	    }
	    else if (command.equals("PList")) {
	         action = new PListAction();
	    }
	    else if (command.equals("PBuy")) {
	         action = new PBuyAction();
	    }
	    else if (command.equals("DoPBuy")) {
	         action = new DoPBuyAction();
	    }else if (command.equals("APMgr")) {
            action = new APMgrAction();
       }else if (command.equals("AUMgr")) {
            action = new AUMgrAction();
       }else if (command.equals("Search")) {
           action = new SearchAction();
      }else if(command.equals("FPW")) {
    	  action = new FPWAction();
      }else if(command.equals("DoFPW")) {
    	  action = new DoFPWAction();
      }
		
		return action;
	}
}
