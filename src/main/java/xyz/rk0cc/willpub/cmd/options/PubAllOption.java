package xyz.rk0cc.willpub.cmd.options;

/**
 * Apply subcommand with <code>--all</code> option that depending on the subcommand's task.
 * <h3>Affect when parsing {@linkplain PubAllOption} in different
 * {@linkplain xyz.rk0cc.willpub.cmd.subcmd.PubSubCommand subcommands}</h3>
 * <table>
 *     <tr>
 *         <th>Subcommands</th>
 *         <th>Affect</th>
 *     </tr>
 *     <tr>
 *         <td>{@link xyz.rk0cc.willpub.cmd.subcmd.PubCacheSubCommand}</td>
 *         <td>
 *             Install all matching versions of a library into cache file (for parsing <code>add</code>
 *             without any additional arguments only)
 *         </td>
 *     </tr>
 *     <tr>
 *         <td>{@link xyz.rk0cc.willpub.cmd.subcmd.PubTokenSubCommand}</td>
 *         <td>
 *             Remove all credentials for uploading package to third-party repository (for parsing <code>remove</code>
 *             without any additional arguments only)
 *         </td>
 *     </tr>
 * </table>
 *
 * @since 1.0.0
 *
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-cache#--all"><code>--all</code></code> option documentation in
 *      <code>dart pub cache</code>.</a>
 * @see <a href="https://dart.dev/tools/pub/cmd/pub-token#removing-credentials-dart-pub-token-remove">
 *          Remove tokens in <code>dart pub token</code>.
 *      </a>
 */
public final class PubAllOption extends AbstractedPubOption {
    /**
     * Construct option for parsing <code>--add</code> flag.
     */
    public PubAllOption() {
        super("all");
    }
}
