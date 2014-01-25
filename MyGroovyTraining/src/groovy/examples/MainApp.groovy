package groovy.examples
import java.awt.BorderLayout as BL
import java.awt.Frame;

import javax.swing.WindowConstants as WC

import groovy.swing.SwingBuilder

import javax.swing.ImageIcon

class MainApp {
	static void main(args) {
		String base = 'http://chart.apis.google.com/chart?'

		//map of parameters which will be added to base address
		def params = [cht:'p3', chs:'250x100', chd:'t:60,40', chl:'Hello|World']

		//a String created from a map in the form k=v concatenated with & sign
		String qs = params.collect { k,v -> "$k=$v" }.join("&")

		params.each { k,v ->
			assert qs.contains("$k=$v")
		}

		new SwingBuilder().edt {
			frame(title:'Hello World!', pack: true, visible: true,
			defaultCloseOperation: WC.EXIT_ON_CLOSE) {
				label(icon: new ImageIcon("$base$qs".toURL()), constraints: BL.CENTER)
			}
		}
	}

}
