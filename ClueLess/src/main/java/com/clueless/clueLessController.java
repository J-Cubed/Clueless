package com.clueless;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
@Controller
public class clueLessController {
	private String errorMessage = "";
	private ArrayList<String> status = new ArrayList<String>();
	private ArrayList<String> moveHistory = new ArrayList<String>();
	private ArrayList<Game> gameList = new ArrayList<Game>();
	
	@RequestMapping("/mainmenu")
	public ModelAndView showMainMenu(
			HttpSession session) {
		System.out.println("in controller - mainmenu");
		
		ModelAndView mv = new ModelAndView("mainmenu");
		return mv;
	}
	
	@RequestMapping(value = "/creategame")
	public ModelAndView showCreateGame(
			HttpSession session) {
		System.out.println("in controller - creategame");
 
		ModelAndView mv = new ModelAndView("creategame");
		mv.addObject("errorMessage", errorMessage);
		errorMessage = "";
		return mv;
	}
	
	@RequestMapping(value = "/creategame", method = RequestMethod.POST)
	public ModelAndView createGame(
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "password", required = false) String password,
			HttpSession session) {
		System.out.println("in controller - posted creategame");
 
		if (type != null && !type.isEmpty() && name != null && !name.isEmpty() && password != null) {
			if (type.equals("private") && password.isEmpty()) {
				errorMessage = "You must enter a password for a private game!";
			} else {
				if (getGameByName(name) != null) {
					errorMessage = "This game name already exists!";
				} else {
					Game game = new Game(name, password);
					
					try {
						session.removeAttribute("s");
						session.removeAttribute("r");
						session.removeAttribute("w");
						session.removeAttribute("notes");
						
						game.getGameBoard().addPlayer(session.getId());
						game.getGameBoard().getPlayer(session.getId()).makeAdmin();
						session.setAttribute("gameId", game.getId());
						gameList.add(game);
						
						return new ModelAndView("redirect:/gamescreen");
					} catch (Exception e) {
						errorMessage = e.getMessage();
					}
				}
			}
		} else if (type != null && !type.isEmpty() && name != null && name.isEmpty()) {
			errorMessage = "Please enter a name!";
		}
		
		System.out.println(errorMessage);
		
		ModelAndView mv = new ModelAndView("creategame");
		mv.addObject("type", type);
		mv.addObject("name", name);
		mv.addObject("password", password);
		mv.addObject("errorMessage", errorMessage);
		errorMessage = "";
		return mv;
	}
	
	@RequestMapping(value = "/joingame")
	public ModelAndView showJoinGame() {
		System.out.println("in controller - joingame");
 
		System.out.println(errorMessage);
		
		ModelAndView mv = new ModelAndView("joingame");
		mv.addObject("errorMessage", errorMessage);
		errorMessage = "";
		return mv;
	}
	
	@RequestMapping(value = "/joingame", method = RequestMethod.POST)
	public ModelAndView joinGame(
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "password", required = false) String password,
			HttpSession session) {
		System.out.println("in controller - posted joingame");
 
		if (type != null && !type.isEmpty() && name != null && !name.isEmpty() && password != null) {
			if (type.equals("private") && password.isEmpty()) {
				errorMessage = "You must enter a password for a private game!";
			} else {
				Game game = getGameByName(name);
				if (game != null) {
					if (game.login(name, password)) {
						try {
							if (game.getGameBoard().getPlayer(session.getId()) == null) {
								session.removeAttribute("s");
								session.removeAttribute("r");
								session.removeAttribute("w");
								session.removeAttribute("notes");
								
								game.getGameBoard().addPlayer(session.getId());
								session.setAttribute("gameId", game.getId());
							}
							return new ModelAndView("redirect:/gamescreen");
						} catch (Exception e) {
							errorMessage = "Error: " + e.getMessage();
						}
					} else
						errorMessage = "Name and/or password is incorrect!";
				} else {
					errorMessage = "Game does not exist yet!";
				}
			}
		} else if (type != null && !type.isEmpty() && name != null && name.isEmpty()) {
			errorMessage = "Please enter a name!";
		}
		
		System.out.println(errorMessage);
		
		ModelAndView mv = new ModelAndView("joingame");
		mv.addObject("type", type);
		mv.addObject("name", name);
		mv.addObject("password", password);		
		mv.addObject("errorMessage", errorMessage);
		errorMessage = "";
		return mv;
	}
	
	@RequestMapping("/gamerules")
    public ModelAndView showGameRules() {
        System.out.println("in controller - gamerules");

        ModelAndView mv = new ModelAndView("gamerules");
        return mv;
    }
	
	@RequestMapping("/gamescreen")
	public ModelAndView showGameScreen(
			@RequestParam(value = "type", required = false) String type,
			HttpSession session) {
		System.out.println("in controller - gamescreen");
		
		Game game = getGameById(String.valueOf(session.getAttribute("gameId")));
		
		if (game != null) {
			if (type != null && !type.isEmpty() && type.equals("endTurn")) {
				game.getGameBoard().endTurn();
			}
			status = game.getGameBoard().getStatus();
			moveHistory = game.getGameBoard().getMoveHistory();
			ArrayList<String> cards = game.getGameBoard().getCards(session.getId());
			String[] curLocations = game.getGameBoard().getLocations();
			Map<String, String> curPlayerLocations = game.getGameBoard().getPlayerLocations();
			
			System.out.println(errorMessage);
			
			ModelAndView mv = new ModelAndView("gamescreen");
			mv.addObject("errorMessage", errorMessage);
			errorMessage = "";
			mv.addObject("status", status);
			mv.addObject("moveHistory", moveHistory);
			mv.addObject("cards", cards);
			boolean isMyTurn = game.getGameBoard().isMyTurn(session.getId());
			mv.addObject("isMyTurn", isMyTurn);
			mv.addObject("isGamePlayable", game.getGameBoard().isGamePlayable());
			mv.addObject("isAdmin", game.getGameBoard().getPlayer(session.getId()).isAdmin());
			mv.addObject("isGameActive", game.getGameBoard().isActive());
			mv.addObject("playerName",game.getGameBoard().getPlayer(session.getId()).name);
			mv.addObject("curLocations", curLocations);
			mv.addObject("curPlayerLocations", curPlayerLocations);
			
			if (isMyTurn && !game.getGameBoard().hasMoved())
				mv.addObject("allowMove", true);
			else
				mv.addObject("allowMove", false);
			if (isMyTurn && game.getGameBoard().canSuggest())
				mv.addObject("allowSuggest", true);
			else
				mv.addObject("allowSuggest", false);
			
			mv.addObject("notes", session.getAttribute("notes"));
			mv.addObject("s", session.getAttribute("s"));
			mv.addObject("r", session.getAttribute("r"));
			mv.addObject("w", session.getAttribute("w"));
			
			return mv;
		} else {
			return new ModelAndView("redirect:/mainmenu");
		}
	}
	
	@RequestMapping("/disprove")
	public ModelAndView showDisprove(
			HttpSession session) {
		System.out.println("in controller - disprove");
		
		Game game = getGameById(String.valueOf(session.getAttribute("gameId")));
		
		if (game != null) {
		
			System.out.println(errorMessage);
	 
			ModelAndView mv = new ModelAndView("disprove");
			mv.addObject("errorMessage", errorMessage);
			errorMessage = "";
			return mv;
		} else {
			return new ModelAndView("redirect:/mainmenu");
		}
	}
	
	@RequestMapping(value = "/detectivenotebook", method = RequestMethod.POST)
	public ModelAndView saveDetectiveNotebook(
			HttpServletRequest request,
			HttpSession session,
			@RequestParam(value = "notes", required = false) String notes,
			@RequestParam(value = "referrer", required = false) String referrer) {
		System.out.println("in controller - posted detectivenotebook");
		
		Game game = getGameById(String.valueOf(session.getAttribute("gameId")));
		
		if (game != null) {
		
			System.out.println(errorMessage);
			
			String[] tmpS = request.getParameterValues("s");
			Boolean[] s = new Boolean[6];
			
			for (int i=0; i<6; i++) {
				s[i] = false;
			}
			if (tmpS != null) {
				for (int i=0; i<tmpS.length; i++) {
				  s[Integer.parseInt(tmpS[i])] = true;
				}
			}
			session.setAttribute("s", s);
			
			String[] tmpR = request.getParameterValues("r");
			Boolean[] r = new Boolean[9];
			
			for (int i=0; i<9; i++) {
				r[i] = false;
			}
			if (tmpR != null) {
				for (int i=0; i<tmpR.length; i++) {
				  r[Integer.parseInt(tmpR[i])] = true;
				}
			}
			session.setAttribute("r", r);
			
			String[] tmpW = request.getParameterValues("w");
			Boolean[] w = new Boolean[6];
			
			for (int i=0; i<6; i++) {
				w[i] = false;
			}
			if (tmpW != null) {
				for (int i=0; i<tmpW.length; i++) {
				  w[Integer.parseInt(tmpW[i])] = true;
				}
			}
			session.setAttribute("w", w);
			
			session.setAttribute("notes", notes);
			
			return null;
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/accusesuggest", method = RequestMethod.POST)
	public ModelAndView accuseSuggest(
			HttpSession session,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "character", required = false) String character,
			@RequestParam(value = "weapon", required = false) String weapon,
			@RequestParam(value = "room", required = false) String room) {
		
		System.out.println("in controller - posted accusesuggest - " + type + " - " + Integer.parseInt(character) + " - " + Integer.parseInt(weapon) + " - " + Integer.parseInt(room));
		
		Game game = getGameById(String.valueOf(session.getAttribute("gameId")));
		
		if (game != null) {
			if (type != null && !type.isEmpty() && type.equals("Suggest")) {
				try {			
					game.getGameBoard().suggest(Integer.parseInt(character),Integer.parseInt(weapon));	
				} catch (Exception e) {
					errorMessage = e.getMessage();
					
					System.out.println("in controller - posted accusesuggest - " + errorMessage);
					
					return showAccuseSuggest("",session);
				}
			} else {
				try {			
					if (game.getGameBoard().accuse(Integer.parseInt(character),Integer.parseInt(weapon),Integer.parseInt(room))) {
						return showGameConclusion(session);
					}
				} catch (Exception e) {
					errorMessage = e.getMessage();
					
					System.out.println("in controller - posted accusesuggest - " + errorMessage);
					
					return showAccuseSuggest("",session);
				}
			}
			
			return showGameScreen("",session);
		}  else {
			return new ModelAndView("redirect:/mainmenu");
		}
	}
	
	@RequestMapping("/accusesuggest")
	public ModelAndView showAccuseSuggest(
			@RequestParam(value = "type", required = false) String type,
			HttpSession session) {
		System.out.println("in controller - accusesuggest");
		
		Game game = getGameById(String.valueOf(session.getAttribute("gameId")));
		
		if (game != null) {
			ArrayList<String> players = game.getGameBoard().getPlayerCardOptions();
			ArrayList<String> weapons = game.getGameBoard().getWeaponCardOptions();
			
			System.out.println(errorMessage);
	 
			ModelAndView mv = new ModelAndView("accusesuggest");
			mv.addObject("type", type);
			mv.addObject("errorMessage", errorMessage);
			errorMessage = "";
			mv.addObject("players", players);
			mv.addObject("weapons", weapons);
			
			if (type != null && !type.isEmpty() && type.equals("Suggest")) {
				String currentPlace = game.getGameBoard().getCurrentPlace();
				mv.addObject("currentPlace",currentPlace);
				mv.addObject("places", null);
			} else {
				ArrayList<String> places = game.getGameBoard().getPlaceCardOptions();
				
				mv.addObject("currentPlace","");
				mv.addObject("places", places);
			}
			return mv;
		}  else {
			return new ModelAndView("redirect:/mainmenu");
		}
	}
	
	@RequestMapping(value = "/movement", method = RequestMethod.POST)
	public ModelAndView move(
			@RequestParam(value = "location", required = false) String location,
			HttpSession session) {
		System.out.println("in controller - posted move - " + Integer.parseInt(location));
		
		Game game = getGameById(String.valueOf(session.getAttribute("gameId")));
		
		if (game != null) {
			try {			
				game.getGameBoard().move(Integer.parseInt(location));	
			} catch (Exception e) {
				errorMessage = e.getMessage();
				
				System.out.println("in controller - posted move - " + errorMessage);
				
				return showMovement(session);
			}
			
			return showGameScreen("", session);
		}  else {
			return new ModelAndView("redirect:/mainmenu");
		}
	}
	
	@RequestMapping("/movement")
	public ModelAndView showMovement(
			HttpSession session) {
		System.out.println("in controller - movement");
		
		Game game = getGameById(String.valueOf(session.getAttribute("gameId")));
		
		if (game != null) {
		
			ArrayList<String> options = game.getGameBoard().getMoveOptions();
			
			System.out.println(errorMessage);
	 
			ModelAndView mv = new ModelAndView("movement");
			mv.addObject("errorMessage", errorMessage);
			errorMessage = "";
			mv.addObject("options", options);
			return mv;
		}  else {
			return new ModelAndView("redirect:/mainmenu");
		}
	}
	
	@RequestMapping("/disproven")
	public ModelAndView showDisproven(
			HttpSession session) {
		System.out.println("in controller - disproven");
		
		Game game = getGameById(String.valueOf(session.getAttribute("gameId")));
		
		if (game != null) {
		
			System.out.println(errorMessage);
	 
			ModelAndView mv = new ModelAndView("disproven");
			mv.addObject("errorMessage", errorMessage);
			errorMessage = "";
			return mv;
		}  else {
			return new ModelAndView("redirect:/mainmenu");
		}
	}
	
	@RequestMapping("/gameconclusion")
	public ModelAndView showGameConclusion(
			HttpSession session) {
		System.out.println("in controller - gameconclusion");
		

		Game game = getGameById(String.valueOf(session.getAttribute("gameId")));
		
		if (game != null) {
		
			ArrayList<String> casefile = game.getGameBoard().getCaseFile();
			
			System.out.println(errorMessage);
	 
			ModelAndView mv = new ModelAndView("gameconclusion");
			mv.addObject("errorMessage", errorMessage);
			errorMessage = "";
			mv.addObject("casefile", casefile);
			return mv;
		}  else {
			return new ModelAndView("redirect:/mainmenu");
		}
	}
	
	@RequestMapping("/gameover")
	public ModelAndView showGameOver(
			HttpSession session) {
		System.out.println("in controller - gameover");
		

		Game game = getGameById(String.valueOf(session.getAttribute("gameId")));
		
		if (game != null) {
		
			ArrayList<String> casefile = game.getGameBoard().getCaseFile();
			
			System.out.println(errorMessage);
	 
			ModelAndView mv = new ModelAndView("gameover");
			mv.addObject("errorMessage", errorMessage);
			errorMessage = "";
			mv.addObject("casefile", casefile);
			return mv;
		}  else {
			return new ModelAndView("redirect:/mainmenu");
		}
	}
	
	@RequestMapping(value="/ajaxStatus", method = RequestMethod.POST)
	public @ResponseBody Status getStatus(
			@RequestParam(value = "startGame", required = false) String startGame,
			@RequestParam(value = "scount", required = false) int scount,
			@RequestParam(value = "mcount", required = false) int mcount,
			HttpSession session) throws Exception {
		
		System.out.println("in controller - posted start");
		
		Game game = getGameById(String.valueOf(session.getAttribute("gameId")));
		
		if (game != null) {
			if (startGame != null && !startGame.isEmpty() && startGame.equals("true")) {
				game.getGameBoard().startGame();
			}
			return getStatus(scount,mcount,session);
		}  else {
			throw new Exception();
		}
	}
	
	@RequestMapping(value="/ajaxStatus", method = RequestMethod.GET)
	public @ResponseBody Status getStatus(
			@RequestParam(value = "scount", required = false) int scount,
			@RequestParam(value = "mcount", required = false) int mcount,
			HttpSession session) throws Exception {
		
		Game game = getGameById(String.valueOf(session.getAttribute("gameId")));
		
		if (game != null) {
			
			boolean isMyTurn = game.getGameBoard().isMyTurn(session.getId());
			boolean isGamePlayable = game.getGameBoard().isGamePlayable();
			boolean isGameActive = game.getGameBoard().isActive();
			boolean allowMove = false;
			boolean allowSuggest = false;
			
			if (isMyTurn && !game.getGameBoard().hasMoved())
				allowMove = true;
			if (isMyTurn && game.getGameBoard().canSuggest())
				allowSuggest = true;
			
			ArrayList<String> status = game.getGameBoard().getStatus();
			ArrayList<String> statusUpdates = new ArrayList<String>(status.subList(scount, status.size()));
			ArrayList<String> moveHistory = game.getGameBoard().getMoveHistory();
			ArrayList<String> moveHistoryUpdates = new ArrayList<String>(moveHistory.subList(mcount, moveHistory.size()));
			String[] curLocations = game.getGameBoard().getLocations();
			Map<String, String> curPlayerLocations = game.getGameBoard().getPlayerLocations();
		
			return new Status(isMyTurn, isGamePlayable, isGameActive, allowSuggest, allowMove, statusUpdates, moveHistoryUpdates, curLocations, curPlayerLocations); 
		}  else {
			throw new Exception();
		}
	}
	
	public Game getGameById(String id) {
		if (gameList != null) {
			for (Game g : gameList) {
				//System.out.println("Game available: " + g.getName() + " id: " + g.getId());
				if (g.getId() != null && !g.getId().isEmpty() && g.getId().equals(id))
					return g;
			}
		}
		return null;
	}
	
	public Game getGameByName(String name) {
		if (gameList != null) {
			for (Game g : gameList) {
				//System.out.println("Game available: " + g.getName() + " id: " + g.getId());
				if (g.getName() != null && !g.getName().isEmpty() && g.getName().equals(name))
					return g;
			}
		}
		return null;
	}
}