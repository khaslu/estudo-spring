package br.com.khaslu.uploadingfiles.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.khaslu.uploadingfiles.Main;

/**
 * The Class FileUploadController.
 *
 * @author Lucas Mota Vieira
 * @since 26/05/2016
 */
@Controller
public class FileUploadController {

	/**
	 * Handle file upload.
	 *
	 * @param name
	 *            the name
	 * @param file
	 *            the file
	 * @param redirectAttributes
	 *            the redirect attributes
	 * @return the string
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/")
	public String handleFileUpload(@RequestParam("name") final String name,
			@RequestParam("file") final MultipartFile file, final RedirectAttributes redirectAttributes) {
		if (name.contains("/")) {
			redirectAttributes.addFlashAttribute("message", "Folder separators not allowed");
			return "redirect:/";
		}
		if (name.contains("/")) {
			redirectAttributes.addFlashAttribute("message", "Relative pathnames not allowed");
			return "redirect:/";
		}

		if (!file.isEmpty()) {
			try {
				final BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(Main.ROOT + "/" + name)));
				FileCopyUtils.copy(file.getInputStream(), stream);
				stream.close();
				redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + name + "!");
			} catch (final Exception e) {
				redirectAttributes.addFlashAttribute("message",
						"You failed to upload " + name + " => " + e.getMessage());
			}
		} else {
			redirectAttributes.addFlashAttribute("message",
					"You failed to upload " + name + " because the file was empty");
		}

		return "redirect:/";
	}

	/**
	 * Provide upload info.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String provideUploadInfo(final Model model) {
		final File rootFolder = new File(Main.ROOT);
		@SuppressWarnings("unused")
		final List<String> fileNames = Arrays.stream(rootFolder.listFiles()).map(f -> f.getName())
				.collect(Collectors.toList());

		model.addAttribute("files",
				Arrays.stream(rootFolder.listFiles()).sorted(Comparator.comparingLong(f -> -1 * f.lastModified()))
						.map(f -> f.getName()).collect(Collectors.toList()));

		return "uploadForm";
	}
}
