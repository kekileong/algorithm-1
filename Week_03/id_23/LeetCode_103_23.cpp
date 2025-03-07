class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> res;
        tranverse(root, res, 0);
        return res;
    }
    
    void tranverse(TreeNode *root, vector<vector<int>> &res, int level) {
        if (root == NULL)
            return;
        
        if (res.size() < level+1) {
            res.push_back(vector<int>());
        }
        
        (level & 1) ? (void)res[level].insert(res[level].begin(), root->val)
                    : res[level].push_back(root->val);
        
        tranverse(root->left, res, level+1);
        tranverse(root->right, res, level+1);
    }
};
