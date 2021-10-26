/*<APPLET CODE=PeriodicTable.class WIDTH=850 HEIGHT=650>
</APPLET>*/

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class PeriodicTable extends Applet
{
	private DrwPanel pnl;
	private InfoPanel ipnl;
	private final int ELEMENTS = 118;

	public void init()
	{
		setLayout(new BorderLayout());
		ipnl = new InfoPanel(ELEMENTS);
		pnl = new DrwPanel(ipnl, ELEMENTS);
		add("Center", pnl);
		add("South", ipnl);
	}
}

class Element
{
	private String an;
	private String as;
	private String aw;
	private String name;

	public Element(String name_1, String an_1, String as_1, String aw_1)
	{
		an = new String(an_1);
		as = new String(as_1);
		aw = new String(aw_1);
		name = new String(name_1);
	}

	String getDesc()
	{
		String endl = System.getProperty("line.separator");
		String desc = new String();

		desc = name + endl + "Atomic Number : " + an + endl + "Atomic Symbol : " + as + endl + "Atomic Weight : " + aw;

		return(desc);
	}
}

class DrwPanel extends Panel implements MouseListener, MouseMotionListener
{
	private InfoPanel target;
	private int mpc = 0;
	private final int recH = 40;
	private final int recW = 35;

	//Map table--
	private Point[] Map;

	//Element table--
	private String[] ET;

	public DrwPanel(InfoPanel target, int ELEMENTS)
	{
		setBackground(Color.white);
		addMouseListener(this);
		addMouseMotionListener(this);
		this.target = target;
		mpc = 0;
		Map = new Point[ELEMENTS];
	}

	public void paint(Graphics g)
	{
		//Should have done this in the first place! Oh well.
		int xshift = 0;
		int yshift = 50;
		mpc = 0;			// mpc = 0 is REALLY necessary here!
		ET = new String[7];
		ET[0] = "H";
		ET[1] = "Li";
		ET[2] = "Na";
		ET[3] = "K";
		ET[4] = "Rb";
		ET[5] = "Cs";
		ET[6] = "Fr";

		for(int i = 0; i < 7; i++)
		{
			g.setColor(Color.orange);
			g.draw3DRect(xshift + 60, yshift + 30 + i * recH + (i > 0 ? i * 5 : 0), recW, recH, true);
			Point p = new Point(xshift + 60, yshift + 30 + i * recH + (i > 0 ? i * 5 : 0));
			Map[mpc++] = p;
			g.fill3DRect(xshift + 60, yshift + 30 + i * recH + (i > 0 ? i * 5 : 0), recW, recH, true);
			g.setColor(Color.black);
			g.drawString(ET[i], xshift + 65, yshift + 30 + i * recH + (i > 0 ? i * 5 : 0) + recH / 2);
		}
		ET = new String[6];
		ET[0] = "Be";
		ET[1] = "Mg";
		ET[2] = "Ca";
		ET[3] = "Sr";
		ET[4] = "Ba";
		ET[5] = "Ra";

		for(int i = 0; i < 6; i++)
		{
			g.setColor(new Color(165, 42, 42)); // Brown Color
			g.draw3DRect(xshift + 65 + recW, yshift + 35 + i * recH + (i > 0 ? i * 5 : 0) + recH, recW, recH, true);
			Point p = new Point(xshift + 65 + recW, yshift + 35 + i * recH + (i > 0 ? i * 5 : 0) + recH);
			Map[mpc++] = p;
			g.fill3DRect(xshift + 65 + recW, yshift + 35 + i * recH + (i > 0 ? i * 5 : 0) + recH, recW, recH, true);
			g.setColor(Color.black);
			g.drawString(ET[i], xshift + 70 + recW, yshift + 35 + i * recH + (i > 0 ? i * 5 : 0) + recH / 2 + recH);
		}
		ET = new String[4 * 10];
		ET[0] = "Sc";
		ET[1] = "Ti";
		ET[2] = "V";
		ET[3] = "Cr";
		ET[4] = "Mn";
		ET[5] = "Fe";
		ET[6] = "Co";
		ET[7] = "Ni";
		ET[8] = "Cu";
		ET[9] = "Zn";
		ET[10] = "Y";
		ET[11] = "Zr";
		ET[12] = "Nb";
		ET[13] = "Mo";
		ET[14] = "Tc";
		ET[15] = "Ru";
		ET[16] = "Rh";
		ET[17] = "Pd";
		ET[18] = "Ag";
		ET[19] = "Cd";
		ET[20] = "Lu";
		ET[21] = "Hf";
		ET[22] = "Ta";
		ET[23] = "W";
		ET[24] = "Re";
		ET[25] = "Os";
		ET[26] = "Ir";
		ET[27] = "Pt";
		ET[28] = "Au";
		ET[29] = "Hg";
		ET[30] = "Lr";
		ET[31] = "Rf";
		ET[32] = "Db";
		ET[33] = "Sg";
		ET[34] = "Bh";
		ET[35] = "Hs";
		ET[36] = "Mt";
		ET[37] = "Uun";
		ET[38] = "Uuu";
		ET[39] = "Uub";
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				g.setColor(new Color(210, 105, 30));
				g.draw3DRect(xshift + 65 + 3 * recW + j * recW + 5 * j, yshift + 45 + i * recH + (i > 0 ? i * 5 : 0) + 3 * recH, recW, recH, true);
				Point p = new Point(xshift + 65 + 3 * recW + j * recW + 5 * j, yshift + 45 + i * recH + (i > 0 ? i * 5 : 0) + 3 * recH);
				Map[mpc++] = p;
				g.fill3DRect(xshift + 65 + 3 * recW + j * recW + 5 * j, yshift + 45 + i * recH + (i > 0 ? i * 5 : 0) + 3 * recH, recW, recH, true);
				g.setColor(Color.black);
				g.drawString(ET[i * 10 + j], xshift + 70 + 3 * recW + j * recW + 5 * j, yshift + 45 + i * recH + (i > 0 ? i * 5 : 0) + recH / 2 + 3 * recH);
			}
		}
		ET = new String[6 * 5];
		ET[0] = "B";
		ET[1] = "C";
		ET[2] = "N";
		ET[3] = "O";
		ET[4] = "F";
		ET[5] = "Al";
		ET[6] = "Si";
		ET[7] = "P";
		ET[8] = "S";
		ET[9] = "Cl";
		ET[10] = "Ga";
		ET[11] = "Ge";
		ET[12] = "As";
		ET[13] = "Se";
		ET[14] = "Br";
		ET[15] = "In";
		ET[16] = "Sn";
		ET[17] = "Sb";
		ET[18] = "Te";
		ET[19] = "I";
		ET[20] = "Tl";
		ET[21] = "Pb";
		ET[22] = "Bi";
		ET[23] = "Po";
		ET[24] = "At";
		ET[25] = "Uut";
		ET[26] = "Uuq";
		ET[27] = "Uup";
		ET[28] = "Uuh";
		ET[29] = "Uus";
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				g.setColor(new Color(0, 180 + j * 10, 255));
				g.draw3DRect(xshift + 80 + 14 * recW + j * recW + 5 * j, yshift + 35 + i * recH + (i > 0 ? i * 5 : 0) + recH, recW, recH, true);
				Point p = new Point(xshift + 80 + 14 * recW + j * recW + 5 * j, yshift + 35 + i * recH + (i > 0 ? i * 5 : 0) + recH);
				Map[mpc++] = p;
				g.fill3DRect(xshift + 80 + 14 * recW + j * recW + 5 * j, yshift + 35 + i * recH + (i > 0 ? i * 5 : 0) + recH, recW, recH, true);
				g.setColor(Color.black);
				g.drawString(ET[i * 5 + j], xshift + 85 + 14 * recW + j * recW + 5 * j, yshift + 35 + i * recH + (i > 0 ? i * 5 : 0) + recH / 2 + recH);
			}
		}
		ET = new String[7];
		ET[0] = "He";
		ET[1] = "Ne";
		ET[2] = "Ar";
		ET[3] = "Kr";
		ET[4] = "Xe";
		ET[5] = "Rn";
		ET[6] = "Uuo";
		for(int i = 0; i < 7; i++)
		{
			g.setColor(new Color(0, 230, 255));
			g.draw3DRect(xshift + 70 + 20 * recW, yshift + 30 + i * recH + (i > 0 ? i * 5 : 0), recW, recH, true);
			Point p = new Point(xshift + 70 + 20 * recW, yshift + 30 + i * recH + (i > 0 ? i * 5 : 0));
			Map[mpc++] = p;
			g.fill3DRect(xshift + 70 + 20 * recW, yshift + 30 + i * recH + (i > 0 ? i * 5 : 0), recW, recH, true);
			g.setColor(Color.black);
			g.drawString(ET[i], xshift + 75 + 20 * recW, yshift + 30 + i * recH + (i > 0 ? i * 5 : 0) + recH / 2);
		}
		ET = new String[28];
		ET[0] = "La";
		ET[1] = "Ce";
		ET[2] = "Pr";
		ET[3] = "Nd";
		ET[4] = "Pm";
		ET[5] = "Sm";
		ET[6] = "Eu";
		ET[7] = "Gd";
		ET[8] = "Tb";
		ET[9] = "Dy";
		ET[10] = "Ho";
		ET[11] = "Er";
		ET[12] = "Tm";
		ET[13] = "Yb";
		ET[14] = "Ac";
		ET[15] = "Th";
		ET[16] = "Pa";
		ET[17] = "U";
		ET[18] = "Np";
		ET[19] = "Pu";
		ET[20] = "Am";
		ET[21] = "Cm";
		ET[22] = "Bk";
		ET[23] = "Cf";
		ET[24] = "Es";
		ET[25] = "Fm";
		ET[26] = "Md";
		ET[27] = "No";
		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < 14; j++)
			{
				if(i == 1)
					g.setColor(new Color(160, 32, 240));
				else
					g.setColor(new Color(110, 105, 30));
				g.draw3DRect(xshift + 170 + j * recW + 5 * j, yshift + 305 + i * recH + (i > 0 ? i * 5 : 0) + recH, recW, recH, true);
				Point p = new Point(xshift + 170 + j * recW + 5 * j, yshift + 305 + i * recH + (i > 0 ? i * 5 : 0) + recH);
				Map[mpc++] = p;
				g.fill3DRect(xshift + 170 + j * recW + 5 * j, yshift + 305 + i * recH + (i > 0 ? i * 5 : 0) + recH, recW, recH, true);
				g.setColor(Color.black);
				g.drawString(ET[i * 14 + j], xshift + 175 + j * recW + 5 * j, yshift + 305 + i * recH + (i > 0 ? i * 5 : 0) + recH / 2 + recH);
			}
		}
		// Add some text information--
		g.setFont(new Font("Times", Font.BOLD, 15));
		g.setColor(Color.black);

		g.drawString("Group", 5, 25);
		g.drawString("Period", 5, 60);

		for(int i = 0; i < 2; i++)
		{
			g.drawString(i + 1 + "", 70 + (recW + 5) * i, 25);
			g.drawString(i + 1 + "A", 63 + (recW + 5) * i, 43);
		}

		for(int i = 2; i < 18; i++)
		{
			g.drawString(i + 1 + "", 95 + (recW + 5) * i, 25);
			if(i <= 6)
			{
				g.drawString(i + 1 + "B", 93 + (recW + 5) * i, 43);
			}
			else if(i == 8)
			{
				g.drawString("8B", 93 + (recW + 5) * i, 43);
			}
			else if(i > 9 && i < 12)
			{
				g.drawString(i - 9 + "B", 93 + (recW + 5) * i, 43);
			}
			else if(i >= 12)
			{
				g.drawString(i - 9 + "A", 93 + (recW + 5) * i, 43);
			}
		}

		for(int i = 0; i < 7; i++)
		{
			g.drawString(i + 1 + "", 20, 105 + (recH + 5) * i);
		}

		g.drawString("*Lanthanides", xshift + 70, yshift + 370);
		g.drawString("**Actinides", xshift + 70, yshift + 410);
		g.drawString("--Rohit Shimpi--", 310, 150);

		g.setFont(new Font("",Font.BOLD,24));
		g.drawString("Click on the Elements to View infornation..", 200, 520);
		g.drawString("Periodic Table", 290, 130);
		g.drawString("*", xshift + 150, yshift + 285);
		g.drawString("**", xshift + 150, yshift + 325);
	}

	public Point []getMap()
	{
		return(Map);
	}

	public int getMapSize()
	{
		return(mpc);
	}

	// Some are not used but need to be defined (MouseListener)

	public void mouseEntered(MouseEvent e)
	{
	}
	public void mousePressed(MouseEvent e)
	{
	}
	public void mouseReleased(MouseEvent e)
	{
	}
	public void mouseClicked(MouseEvent e)
	{
		e.consume();
		target.setCoords(e.getX(), e.getY(), getMap(), getMapSize(), recW, recH);
	}
	public void mouseExited(MouseEvent e)
	{
	}

	// Some are not used but need to be defined (MouseMotionListener)
	public void mouseMoved(MouseEvent e)
	{
		//target.setCoords(e.getX(), e.getY(), getMap(), getMapSize(), recW, recH);
	}
	public void mouseDragged(MouseEvent e)
	{
	}
}

class InfoPanel extends Panel
{
	private int X = 0;
	private int Y = 0;
	private Element[] es;
	private TextArea ta;

	public InfoPanel(int ELEMENTS)
	{
		setBackground(Color.white);
		ta = new TextArea("", 5, 50, TextArea.SCROLLBARS_NONE);
		ta.setBackground(Color.white);
		ta.setForeground(Color.black);
		ta.setEditable(false);
		add(ta);

		es = new Element[ELEMENTS];

		es[0] = new Element("Hydrogen", "1", "H", "1.01");
		es[1] = new Element("Lithium", "3", "Li", "6.941");
		es[2] = new Element("Sodium", "11", "Na", "22.99");
		es[3] = new Element("Potassium", "19", "K", "39.10");
		es[4] = new Element("Rubidium", "37", "Rb", "85.47");
		es[5] = new Element("Caesium", "55", "Cs", "132.90");
		es[6] = new Element("Francium", "87", "Fr", "223.00");

		es[7] = new Element("Beryllium", "4", "Be", "9.012");
		es[8] = new Element("Magnesium", "12", "Mg", "24.31");
		es[9] = new Element("Calcium", "20", "Ca", "40.08");
		es[10] = new Element("Strontium", "38", "Sr", "87.62");
		es[11] = new Element("Barium", "56", "Ba", "137.30");
		es[12] = new Element("Radium", "88", "Ra", "226.00");

		es[13] = new Element("Scandium", "21", "Sc", "44.96");
		es[14] = new Element("Yttrium", "39", "Y", "88.91");
		es[15] = new Element("Lutetium", "71", "Lu", "174.97");
		es[16] = new Element("Lawrencium", "103", "Lr", "262.00");

		es[17] = new Element("Titanium", "22", "Ti", "47.87");
		es[18] = new Element("Zirconium", "40", "Zr", "91.22");
		es[19] = new Element("Hafnium", "72", "Hf", "178.49");
		es[20] = new Element("Rutherfordium", "104", "Rf", "261.00");

		es[21] = new Element("Vanadium", "23", "V", "50.94");
		es[22] = new Element("Niobium", "41", "Nb", "92.91");
		es[23] = new Element("Tantalum", "73", "Ta", "180.95");
		es[24] = new Element("Dubnium", "105", "Db", "262.00");

		es[25] = new Element("Chromium", "24", "Cr", "51.996");
		es[26] = new Element("Molybdenum", "42", "Mo", "95.94");
		es[27] = new Element("Tungsten", "74", "W", "183.84");
		es[28] = new Element("Seaborgium", "106", "Sg", "263.00");

		es[29] = new Element("Manganese", "25", "Mn", "54.94");
		es[30] = new Element("Technetium", "43", "Tc", "98.00");
		es[31] = new Element("Rhenium", "75", "Re", "186.21");
		es[32] = new Element("Bohrium", "107", "Bh", "262.00");

		es[33] = new Element("Iron", "26", "Fe", "55.85");
		es[34] = new Element("Ruthenium", "44", "Ru", "101.07");
		es[35] = new Element("Osmium", "76", "Os", "190.23");
		es[36] = new Element("Hassium", "108", "Hs", "265.00");

		es[37] = new Element("Cobalt", "27", "Co", "58.93");
		es[38] = new Element("Rhodium", "45", "Rh", "102.91");
		es[39] = new Element("Iridium", "77", "Ir", "192.22");
		es[40] = new Element("Meitnerium", "109", "Mt", "266.00");

		es[41] = new Element("Nickel", "28", "Ni", "58.69");
		es[42] = new Element("Palladium", "46", "Pd", "106.42");
		es[43] = new Element("Platinum", "78", "Pt", "195.08");
		es[44] = new Element("Ununnilium", "110", "Uun", "269.00");

		es[45] = new Element("Copper", "29", "Cu", "63.55");
		es[46] = new Element("Silver", "47", "Ag", "107.87");
		es[47] = new Element("Gold", "79", "Au", "196.97");
		es[48] = new Element("Unununium", "111", "Uuu", "272.00");

		es[49] = new Element("Zinc", "30", "Zn", "65.39");
		es[50] = new Element("Cadmium", "48", "Cd", "112.41");
		es[51] = new Element("Mercury", "80", "Hg", "200.59");
		es[52] = new Element("Ununbium", "112", "Uub", "277.00");

		es[53] = new Element("Boron", "5", "B", "10.81");
		es[54] = new Element("Aluminum", "13", "Al", "26.98");
		es[55] = new Element("Gallium", "31", "Ga", "69.72");
		es[56] = new Element("Indium", "49", "In", "114.82");
		es[57] = new Element("Thallium", "81", "Tl", "204.38");
		es[58] = new Element("Ununtrium", "113", "Uut", "?");

		es[59] = new Element("Carbon", "6", "C", "12.01");
		es[60] = new Element("Silicon", "14", "Si", "28.09");
		es[61] = new Element("Germanium", "32", "Ge", "72.61");
		es[62] = new Element("Tin", "50", "Sn", "118.71");
		es[63] = new Element("Lead", "82", "Pb", "207.2");
		es[64] = new Element("Ununquadium", "114", "Uuq", "285.00");

		es[65] = new Element("Nitrogen", "7", "N", "14.01");
		es[66] = new Element("Phosphorus", "15", "P", "30.97");
		es[67] = new Element("Arsenic", "33", "As", "74.92");
		es[68] = new Element("Antimony", "51", "Sb", "121.76");
		es[69] = new Element("Bismuth", "83", "Bi", "208.98");
		es[70] = new Element("?", "115", "Uup", "?");

		es[71] = new Element("Oxygen", "8", "O", "15.999");
		es[72] = new Element("Sulfur", "16", "S", "32.07");
		es[73] = new Element("Selenium", "34", "Se", "78.96");
		es[74] = new Element("Tellurium", "52", "Te", "127.60");
		es[75] = new Element("Polonium", "84", "Po", "209.00");
		es[76] = new Element("Ununhexium", "116", "Uuh", "289.00");

		es[77] = new Element("Flourine", "9", "F", "18.998");
		es[78] = new Element("Chlorine", "17", "Cl", "35.45");
		es[79] = new Element("Bromine", "35", "Br", "79.90");
		es[80] = new Element("Iodine", "53", "I", "126.90");
		es[81] = new Element("Astatine", "85", "At", "210.00");
		es[82] = new Element("?", "117", "Uus", "?");

		es[83] = new Element("Helium", "2", "He", "4.003");
		es[84] = new Element("Neon", "10", "Ne", "20.18");
		es[85] = new Element("Argon", "18", "Ar", "39.95");
		es[86] = new Element("Krypton", "36", "Kr", "83.80");
		es[87] = new Element("Xenon", "54", "Xe", "131.29");
		es[88] = new Element("Radon", "86", "Rn", "222.00");
		es[89] = new Element("Ununoctium", "118", "Uuo", "293.00");

		es[90] = new Element("Lanthanum", "57", "La", "138.91");
		es[91] = new Element("Actinium", "89", "Ac", "227.03");
		es[92] = new Element("Cerium", "58", "Ce", "140.116");
		es[93] = new Element("Thorium", "90", "Th", "232.04");
		es[94] = new Element("Praseodymium", "59", "Pr", "140.91");
		es[95] = new Element("Protactinium", "91", "Pa", "231.06");
		es[96] = new Element("Neodymium", "60", "Nd", "144.24");
		es[97] = new Element("Uranium", "92", "U", "238.03");
		es[98] = new Element("Promethium", "61", "Pm", "145.00");
		es[99] = new Element("Neptunium", "93", "Np", "237.00");
		es[100] = new Element("Samarium", "62", "Sm", "150.36");
		es[101] = new Element("Plutonium", "94", "Pu", "244.00");
		es[102] = new Element("Europium", "63", "Eu", "151.96");
		es[103] = new Element("Americium", "95", "Am", "243.00");
		es[104] = new Element("Gadolinium", "64", "Gd", "157.25");
		es[105] = new Element("Curium", "96", "Cm", "247.00");
		es[106] = new Element("Terbium", "65", "Tb", "158.93");
		es[107] = new Element("Berkelium", "97", "Bk", "247.00");
		es[108] = new Element("Dysprosium", "66", "Dy", "162.50");
		es[109] = new Element("Californium", "98", "Cf", "251.00");
		es[110] = new Element("Holmium", "67", "Ho", "164.93");
		es[111] = new Element("Einsteinium", "99", "Es", "252.00");
		es[112] = new Element("Erbium", "68", "Er", "167.26");
		es[113] = new Element("Fermium", "100", "Fm", "257.00");
		es[114] = new Element("Thulium", "69", "Tm", "168.93");
		es[115] = new Element("Mendelvium", "101", "Md", "258.00");
		es[116] = new Element("Ytterbium", "70", "Yb", "173.04");
		es[117] = new Element("Nobelium", "102", "No", "259.00");
	}

	public void setCoords(int x, int y, Point []Map, int mapsize, int recW, int recH)
	{
		X = x;
		Y = y;
		int p = 0;
		Point P = new Point();
		Boolean set = Boolean.FALSE;

		for(int i = 0; i < mapsize; i++)
		{
			if(i <= 13)
			{
				p = i;
			}
			else if(i >= 14 && i <= 22)
			{
				p = i + 3 * (i % 13);
			}
			else if(i >= 23 && i <= 32)
			{
				p = i - 9 + 4 * (i % 23) - 1 * (i % 23);
			}
			else if(i >= 33 && i <= 42)
			{
				p = i - 18 + 4 * (i % 33) - 1 * (i % 33);
			}
			else if(i >= 43 && i <= 52)
			{
				p = i - 27 + 4 * (i % 43) - 1 * (i % 43);
			}
			else if(i >= 53 && i <= 57)
			{
				p = i + 5 * (i % 53);
			}
			else if(i >= 58 && i <= 62)
			{
				p = i - 4 + 6 * (i % 58) - 1 * (i % 58);
			}
			else if(i >= 63 && i <= 67)
			{
				p = i - 8 + 6 * (i % 63) - 1 * (i % 63);
			}
			else if(i >= 68 && i <= 72)
			{
				p = i - 12 + 6 * (i % 68) - 1 * (i % 68);
			}
			else if(i >= 73 && i <= 77)
			{
				p = i - 16 + 6 * (i % 73) - 1 * (i % 73);
			}
			else if(i >= 78 && i <= 82)
			{
				p = i - 20 + 6 * (i % 78) - 1 * (i % 78);
			}
			else if(i >= 83 && i <= 89)
			{
				p = i;
			}
			else if(i >= 90 && i <= 103)
			{
				p =  i + 1 * (i % 90);
			}
			else if(i >= 104 && i <= 117)
			{
				p = i - 13 + 2 * (i % 104) - 1 * (i % 104);
			}
			if(X >= Map[i].x && X <= (Map[i].x + recW) && Y >= Map[i].y && Y <= (Map[i].y + recH))
			{
				set = Boolean.TRUE;
				if(!ta.getText().equals(es[p].getDesc()))
					ta.setText(es[p].getDesc());
				break;
			}
		}

		if(!set.booleanValue())
		{
			if(!ta.getText().equals(""))
			  ta.setText("");
		}
	}
}

/*this program can represent the periodic table in java applet using the map and we can see the atomic number and
and some bacic information about element
it is because I love periodic table during my school days
it was help me to create this project ....
 */