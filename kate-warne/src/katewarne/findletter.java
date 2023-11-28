package intro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class findletter extends JFrame {

	public findletter() {
		setTitle("Find Letter");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		// Load and resize background image
		String imagePath = "C:/Users/simpl/OneDrive/문서/카카오톡 받은 파일/still-life-of-vintage-writing-of-a-love-letter.jpg";
		try {
			BufferedImage originalImage = ImageIO.read(new File(imagePath));
			Image scaledImage = originalImage.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
			ImageIcon backgroundIcon = new ImageIcon(scaledImage);
			JLabel backgroundLabel = new JLabel(backgroundIcon);
			add(backgroundLabel, BorderLayout.CENTER);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Create and customize the "편지읽기" button
		JButton readButton = new JButton("read letter");
		readButton.setFont(new Font("Arial", Font.BOLD, 20));
		readButton.setForeground(Color.WHITE);
		readButton.setBackground(new Color(0, 128, 0)); // 초록색 배경
		readButton.setBorderPainted(false); // 버튼 테두리 없애기

		// Add mouse hover effect
		readButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// When mouse enters the button
				readButton.setBackground(new Color(0, 0, 128)); // 파란색 배경
				readButton.setFont(new Font("Arial", Font.BOLD, 22)); // 크기 증가
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// When mouse exits the button
				readButton.setBackground(new Color(0, 128, 0)); // 다시 초록색 배경
				readButton.setFont(new Font("Arial", Font.BOLD, 20)); // 크기 복원
			}
		});

		// Create a panel for the button with FlowLayout
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setOpaque(false); // Make the panel transparent
		buttonPanel.add(readButton);

		add(buttonPanel, BorderLayout.SOUTH);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new findletter());
	}
}
