# github api

GraphQL を使うのが便利そう。REST だといらない項目が多すぎる

## GraphQL

https://docs.github.com/ja/graphql/overview/explorer で色々試せる

こんな感じで必要な情報が取れる。ページングはもうちょっと調べないといけない。  
`baseRefName`のブランチは消えてても大丈夫

```
{
  organization(login: "hoge") {
    repository(name: "fuga") {
      pullRequests(
        first: 10
        baseRefName: "base-branch-name"
        orderBy: {field: CREATED_AT, direction: DESC}
      ) {
        totalCount
        pageInfo {
          endCursor
          startCursor
        }
        edges {
          node {
            id
            title
            state
            additions
            deletions
            createdAt
            mergedAt
            closedAt
            commits(first: 10) {
              nodes {
                commit {
                  id
                  message
                  committedDate
                }
              }
            }
            files {
              totalCount
            }
          }
        }
      }
    }
  }
}
```