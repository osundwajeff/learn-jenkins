pipelineJob('pipeline-v3') {
    triggers {
        genericVariables {
            genericVariable {
                key('action')
                value("\$.action")
                expressionType('JSONPath') //Optional, defaults to JSONPath
                regexpFilter('') //Optional, defaults to empty string
                defaultValue('') //Optional, defaults to empty string
            }
            genericVariable {
                key('isMerged')
                value("\$.pull_request.merged")
                expressionType('JSONPath') //Optional, defaults to JSONPath
                regexpFilter('') //Optional, defaults to empty string
                defaultValue('') //Optional, defaults to empty string
            }
            genericVariable {
                key('commit')
                value("\$.pull_request.head.sha")
                expressionType('JSONPath') //Optional, defaults to JSONPath
                regexpFilter('') //Optional, defaults to empty string
                defaultValue('') //Optional, defaults to empty string
            }
            genericVariable {
                key('mergeCommit')
                value("\$.pull_request.merge_commit_sha")
                expressionType('JSONPath') //Optional, defaults to JSONPath
                regexpFilter('') //Optional, defaults to empty string
                defaultValue('') //Optional, defaults to empty string
            }
            genericVariable {
                key('sourceBranch')
                value("\$.pull_request.head.ref")
                expressionType('JSONPath') //Optional, defaults to JSONPath
                regexpFilter('') //Optional, defaults to empty string
                defaultValue('') //Optional, defaults to empty string
            }
            genericVariable {
                key('targetBranch')
                value("\$.pull_request.base.ref")
                expressionType('JSONPath') //Optional, defaults to JSONPath
                regexpFilter('') //Optional, defaults to empty string
                defaultValue('') //Optional, defaults to empty string
            }
            genericVariable {
                key('sourceCloneURL')
                value("\$.repository.clone_url")
                expressionType('JSONPath') //Optional, defaults to JSONPath
                regexpFilter('') //Optional, defaults to empty string
                defaultValue('') //Optional, defaults to empty string
            }
            genericVariable {
                key('label')
                value("\$.pull_request.labels[?(@.name == 'draft')].name")
                expressionType('JSONPath') //Optional, defaults to JSONPath
                regexpFilter('') //Optional, defaults to empty string
                defaultValue('') //Optional, defaults to empty string
            }
            genericVariable {
                key('isDraft')
                value("\$.pull_request.draft")
                expressionType('JSONPath') //Optional, defaults to JSONPath
                regexpFilter('') //Optional, defaults to empty string
                defaultValue('') //Optional, defaults to empty string
            }
            genericVariable {
                key('pullRequestURL')
                value("\$.pull_request.html_url")
                expressionType('JSONPath') //Optional, defaults to JSONPath
                regexpFilter('') //Optional, defaults to empty string
                defaultValue('') //Optional, defaults to empty string
            }
            genericVariable {
                key('pullRequestAPIURL')
                value("\$.pull_request.issue_url")
                expressionType('JSONPath') //Optional, defaults to JSONPath
                regexpFilter('') //Optional, defaults to empty string
                defaultValue('') //Optional, defaults to empty string
            }
            genericVariable {
                key('pullRequestStatusURL')
                value("\$.pull_request.statuses_url")
                expressionType('JSONPath') //Optional, defaults to JSONPath
                regexpFilter('') //Optional, defaults to empty string
                defaultValue('') //Optional, defaults to empty string
            }
        }
        regexpFilterText("\$action\$label\$isDraft")
        // Add actions to below expression to trigger job for more pull request actions
        regexpFilterExpression("^(?!.*draft)(?!.*true\$)(closed|opened|synchronize|unlabeled).*")
        causeString("Pull request \$action from \$sourceBranch to \$targetBranch")
    }
}
