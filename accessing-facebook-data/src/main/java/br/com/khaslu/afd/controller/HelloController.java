package br.com.khaslu.afd.controller;

import javax.inject.Inject;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The Class HelloController.
 *
 * @author Lucas Mota Vieira
 * @since 26/05/2016
 */
@Controller
@RequestMapping("/")
public class HelloController {

	/** The facebook. */
	private final Facebook facebook;

	/** The connection repository. */
	private final ConnectionRepository connectionRepository;

	/**
	 * Instantiates a new hello controller.
	 *
	 * @param facebook
	 *            the facebook
	 * @param connectionRepository
	 *            the connection repository
	 */
	@Inject
	public HelloController(final Facebook facebook, final ConnectionRepository connectionRepository) {
		this.facebook = facebook;
		this.connectionRepository = connectionRepository;
	}

	/**
	 * Hello facebook.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String helloFacebook(final Model model) {
		if (this.connectionRepository.findPrimaryConnection(Facebook.class) == null) {
			return "redirect:/connect/facebook";
		}

		model.addAttribute("facebookProfile", this.facebook.userOperations().getUserProfile());
		final PagedList<Post> feed = this.facebook.feedOperations().getFeed();
		model.addAttribute("feed", feed);
		return "hello";
	}

}