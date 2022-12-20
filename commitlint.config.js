module.exports = {
    extends: ["@commitlint/config-angular"], rules: {
        "subject-case": [2, "always", "sentence-case"],
        "type-case": [2, "always", 'lowerCase'],
        "type-enum": [2, "always", ['build', 'ci', 'docs', 'feat', 'fix', 'perf', 'refactor', 'revert', 'style', 'test', 'chore']]
    },
};