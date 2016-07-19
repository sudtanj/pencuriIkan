package temp;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import de.craften.ui.swingmaterial.MaterialComboBox;
import langCode.LanguageCode;

public class LanguageSelector extends MaterialComboBox {
	private static final long serialVersionUID = 4715799003590054842L;

	public LanguageSelector() {
		super();
		for (LanguageCode code : LanguageCode.values())
			this.addItem(code.getName());
		this.setSelectedItem(Settings.getCurrentLang());
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Settings.language = ((LanguageSelector) arg0.getSource()).getSelectedItem().toString();
				for (Component temp : Frame.getFrames()[0].getComponents()) {
					temp.repaint();
				}
			}
		});
		if (netIsAvailable())
			this.setToolTipText(new SuperString("Choose Language"));
		else {
			this.setEnabled(false);
			this.setToolTipText(new SuperString("Internet connection is need for translation"));
		}
	}

	private boolean netIsAvailable() {
		try {
			new URL("http://www.google.com").openConnection().connect();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
